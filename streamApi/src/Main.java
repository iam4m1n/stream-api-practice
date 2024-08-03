import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static int[] convertStreamToArray(Stream<Integer> stream)
    {
        return stream.mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws Exception {

        File file = new File("E:\\Programming\\neshan\\java\\task\\stream_api\\streamApi\\src\\err.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String result;

        List<String> data = new ArrayList<>();

        while ((result = br.readLine())!= null){
//            System.out.println(result);
            data.add(result);
        }

//        System.out.println(data);

        System.out.println("List of all responses:");
        data.stream()
                .filter((String str) -> {
                    int ascii =  str.charAt(4);
                    return  ascii > 60;
                })
                .forEach(n -> {
                    String finalResult = n.substring(4, n.length());
                    System.out.println(finalResult);
                });


        System.out.println("\n\n\nall errors in range of 400:");
        data.stream()
                .filter((String str) -> {
                    int temp = str.charAt(0);
                    return temp == 52;
                }).forEach(n -> System.out.println(n));


        System.out.println("\n\n\nError Codes Count:");
        data.stream().forEach((String str) -> {
            long count = data.stream().filter(num -> num.substring(0, 4).equals(str.substring(0, 4))).count();
            System.out.println("Number of " + str.substring(0, 4) + ": " + count);
        });




        int[] arr = convertStreamToArray(data.stream().map((String str) -> {
            return Integer.parseInt(str.substring(0, 3));
        }));
        int[] cpe = new int[200];
        double sum = 0;
        double count = 0;
        for (int i = 0; i < arr.length; i++) {
            cpe[arr[i] - 400]++;
        }

        for (int i = 0; i < cpe.length; i++) {
            sum += cpe[i];
            if(cpe[i] != 0)
                count++;
        }

        System.out.println("The Average count for all errors is: " + sum/count);


    }

}