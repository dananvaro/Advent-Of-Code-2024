import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThree  {

    public static void main(String[] args) {

        String filePath = "src\\resource\\day3Input.txt";

        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));

            String s = String.join("", lines);

            //System.out.println(s);

            String regex = "mul\\((-?\\d+),(-?\\d+)\\)";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(s);

            int sum = 0;


            while (matcher.find()) {

                int x = Integer.parseInt(matcher.group(1));
                int y = Integer.parseInt(matcher.group(2));

                int z= x*y;

                sum += z;




            }

            System.out.println(sum);



        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }





    }
}
