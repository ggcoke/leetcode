import java.util.*;

/**
 * Desc here
 *
 * @author Wang Huisong(ggcoke@foxmail.com)
 */
public class DesignTwitter {
    private static long count;
    class Tweet {
        public long time;
        public int tweetId;

        public Tweet(int tweetId, long time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Tweet[id= " + tweetId + ", time=" + time + "]";
        }
    }

    private Map<Integer/* followee */, List<Integer>/* follower */> sFollowShip;
    private Map<Integer/* user id */, List<Tweet>/* tweets */> sUserTweets;
    private Map<Integer/* user id */, List<Tweet>/* post */> sUserPosts;


    /** Initialize your data structure here. */
    public DesignTwitter() {
        count = 0;
        sFollowShip = new HashMap<>();
        sUserTweets = new HashMap<>();
        sUserPosts = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, count++);

        if (!sUserPosts.containsKey(userId)) {
            List<Tweet> posts = new ArrayList<>();
            sUserPosts.put(userId, posts);
        }

        sUserPosts.get(userId).add(newTweet);
        insertTweetToTimeline(sUserTweets, userId, newTweet);

        if (sFollowShip.containsKey(userId)) {
            List<Integer> followers = sFollowShip.get(userId);
            if (followers != null && followers.size() > 0) {
                for (int followerId : followers) {
                    insertTweetToTimeline(sUserTweets, followerId, newTweet);
                }
            }
        }
    }

    private Comparator<Tweet> sTweetComparator = new Comparator<Tweet>() {
        @Override
        public int compare(Tweet tweet, Tweet t1) {
            if (tweet.time > t1.time) {
                return -1;
            } else if (tweet.time == t1.time) {
                return 0;
            } else {
                return 1;
            }
        }
    };

    private void insertTweetToTimeline(Map<Integer, List<Tweet>> map, int userId, Tweet tweet) {
        if (map == null) {
            return;
        }

        if (!map.containsKey(userId)) {
            List<Tweet> tweets = new ArrayList<>();
            map.put(userId, tweets);
        }

        List<Tweet> old = map.get(userId);

        Queue<Tweet> queue = new PriorityQueue<>(sTweetComparator);
        for (Tweet t : old) {
            queue.add(t);
        }
        queue.add(tweet);

        old.clear();
        while (queue != null && !queue.isEmpty()) {
            old.add(queue.poll());
        }

        map.put(userId, old);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
     * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (sUserTweets != null && sUserTweets.containsKey(userId)) {
            List<Tweet> tweets = sUserTweets.get(userId);
            if (tweets == null || tweets.size() <= 0) {
                return feed;
            }

            for (int i = 0; i < tweets.size() && i < 10; i++) {
                feed.add(tweets.get(i).tweetId);
            }
        }

        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }

        if (!sFollowShip.containsKey(followeeId)) {
            List<Integer> followers = new ArrayList<>();
            sFollowShip.put(followeeId, followers);
        }

        if (sFollowShip.get(followeeId).contains(Integer.valueOf(followerId))) {
            return;
        }
        sFollowShip.get(followeeId).add(followerId);

        if (!sUserPosts.containsKey(followeeId)) {
            // followee has no tweet
            return;
        }

        List<Tweet> posts = sUserPosts.get(followeeId);
        for (Tweet tweet : posts) {
            insertTweetToTimeline(sUserTweets, followerId, tweet);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        if (!sFollowShip.containsKey(followeeId) || followeeId == followerId) {
            return;
        }

        sFollowShip.get(followeeId).remove(Integer.valueOf(followerId));

        if (sUserTweets.containsKey(followerId) && sUserPosts.containsKey(followeeId)) {
            List<Tweet> feeds = sUserTweets.get(followerId);
            List<Tweet> posts = sUserPosts.get(followeeId);

            for (Tweet post : posts) {
                removeTweetFromTimeline(feeds, post);
            }
        }
    }

    private void removeTweetFromTimeline(List<Tweet> feeds, Tweet tweet) {
        if (feeds == null) {
            return;
        }

        feeds.remove(tweet);
    }


    public static void main(String[] args) {
        DesignTwitter design = new DesignTwitter();

        design.postTweet(2, 5);
//        List<Integer> tweets = design.getNewsFeed(1);
//        System.out.println(tweets);
//        design.follow(1, 2);
//        design.postTweet(2, 6);
//        design.postTweet(2, 7);
//        tweets = design.getNewsFeed(1);
//        System.out.println(tweets);
//        design.unfollow(1, 2);
//        design.postTweet(3, 9);
//        design.follow(1, 3);
        design.follow(1, 2);
        design.unfollow(1, 2);
        design.unfollow(1, 2);
        List<Integer> tweets = design.getNewsFeed(1);
        System.out.println(tweets);
    }
}
