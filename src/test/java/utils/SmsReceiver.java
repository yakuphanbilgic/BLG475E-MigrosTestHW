package utils;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.joda.time.DateTime;

public class SmsReceiver {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC0e393cb9591dc94e5735ecc178ab0f69";
    public static final String AUTH_TOKEN =
            "9682f04b8a63a93c3d6f4789ed860fb8";


    public static String returnLastOTP() {
        String lastOTP = "init";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        ResourceSet<Message> messages = Message.reader()
                .limit(20)
                .read();

        for(Message record : messages) {
            lastOTP = record.getBody();
            System.out.println(record.getBody());
        }

        return lastOTP;
    }
}