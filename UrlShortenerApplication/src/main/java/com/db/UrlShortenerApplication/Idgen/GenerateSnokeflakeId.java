package com.db.UrlShortenerApplication.Idgen;
import java.util.Random;
import java.time.Duration;
import java.time.Instant;

public class GenerateSnokeflakeId {

    private static String MachineId="0101100010";
    

    private static Instant epoch = Instant.parse( "2000-01-01T00:00:00Z" ) ;

    public static String generate(){

       StringBuilder uniqueId=new StringBuilder("0");
       String TimestampId=String.format("%1$"+41+"s",getTimestamp()).replace(' ', '0');
       String SequenceId=String.format("%1$"+12+"s",getSequence()).replace(' ', '0');
       MachineId=String.format("%1$"+10+"s",getMachineSeq()).replace(' ', '0');
       uniqueId.append(TimestampId).append(MachineId).append(SequenceId);
       return uniqueId.toString();

    }

    private static String getTimestamp(){
            Instant currentTime=Instant.now();
            Duration dur=Duration.between(epoch, currentTime);
            return Long.toBinaryString(dur.toMillis());
    }

    private static String getSequence(){
      Random random = null;
        String binaryString = "";

        try {
            random = new Random();
            binaryString = Integer.toBinaryString(random.nextInt(0, 4095));
            return binaryString;

        } catch (Exception e) {
            System.err.println("An unexpected error occurred while generating the sequence.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "0"; 
        }
    }

    private static String getMachineSeq(){
      Random random = null;
        String binaryString = "";

        try {
            random = new Random();
            binaryString = Integer.toBinaryString(random.nextInt(0, 1023));
            return binaryString;

        } catch (Exception e) {
            System.err.println("An unexpected error occurred while generating the sequence.");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return "0"; 
        }
    }
}
