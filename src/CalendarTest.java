import java.util.Calendar;
import java.util.Random;

/**
 * Desc here
 *
 * @author Wang Huisong(wanghuisong@le.com)
 */
public class CalendarTest {

    private static final int[] SAMPLE_HOUR = new int[]{
            /*0*/6,   /*1*/6,   /*2*/6,   /*3*/6,   /*4*/6,   /*5*/6,
            /*6*/7,   /*7*/9,   /*8*/9,   /*9*/10,  /*10*/11, /*11*/12,
            /*12*/13, /*13*/14, /*14*/15, /*15*/16, /*16*/17, /*17*/21,
            /*18*/21, /*19*/21, /*20*/21, /*21*/22, /*22*/23, /*23*/6,
            /*invalid hour*/6
    };
    public static void calNext(Calendar calendar) {
        Calendar current = Calendar.getInstance();
        current.setTimeInMillis(calendar.getTimeInMillis());

        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);

        int nextHour = SAMPLE_HOUR[currentHour];
        int nextMinute = randomIntBetween(0, 10);
        int nextSecond = randomIntBetween(10, 20);

        if (nextHour < currentHour) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        /*
        boolean positive = calendar.get(Calendar.MINUTE) % 2 == 0;
        if (!positive) {
            nextHour--;
            nextMinute = 60 - nextMinute;
        }
        */

        calendar.set(Calendar.HOUR_OF_DAY, nextHour);
        calendar.set(Calendar.MINUTE, nextMinute);
        calendar.set(Calendar.SECOND, nextSecond);

        if ((calendar.getTimeInMillis() - current.getTimeInMillis()) < 30 * 60 * 1000) {
            calendar.add(Calendar.HOUR_OF_DAY, 1);
        }

        System.out.println("Next hour is " + calendar.get(Calendar.HOUR_OF_DAY) + ", and minute is " + calendar.get(Calendar.MINUTE));
    }

    protected static int randomIntBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max + 1) % (max - min + 1) + min;
    }

    public static void main(String[] args) {
        Calendar current = Calendar.getInstance();
        current.set(Calendar.HOUR_OF_DAY, 14);
        current.set(Calendar.MINUTE, 57);

        CalendarTest.calNext(current);
    }
}
