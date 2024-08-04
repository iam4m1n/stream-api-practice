import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

//        List<String> data = new ArrayList<>();
        List<Error> data = new ArrayList<>();

        while ((result = br.readLine())!= null){
            data.add(new Error(Integer.parseInt(result.split(" ")[0]), result.split(" ")[1]));
        }

        System.out.println("\n\nList of all responses:");
        List<String> task1 = data.stream()
                .distinct()
                .map( n -> n.errorDetail).collect(Collectors.toList());

        System.out.println(task1);


        System.out.println("\n\n\nall errors in range of 400:");
        List<Integer> task2 = data.stream()
                .filter(err -> err.errorNumber > 399 && err.errorNumber<500)
                .map(n -> n.errorNumber)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(task2);



        System.out.println("\n\n\nError Codes Count:");

        Map<Integer, Long> itemCount = data.stream().distinct()
                .collect(Collectors.groupingBy(e -> e.errorNumber, Collectors.counting()));

        itemCount.forEach((k, c) -> System.out.println("Number of " + k + " : " + c));






        System.out.println("\n\n\nSorting all code errors by count:");
        itemCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(n -> System.out.print(n + ", "));



        



        double all = itemCount.values().stream().mapToInt(Long::intValue).sum();
        double tedad = itemCount.values().size();

        double Avg = all/tedad;

        System.out.println("\n\n\nThe Average count for all errors is: " + Avg);

        System.out.println("\nList of all errors above avg:");

        List <Integer> task5 = itemCount.entrySet()
                .stream().
                map( n -> n.toString())
                .filter( (String n) -> Integer.parseInt(n.split("=")[1]) > Avg)
                .map( n -> Integer.parseInt(n.split("=")[0]))
                .collect(Collectors.toList());

        System.out.println(task5);


        System.out.println("\n\n\nErrors in range of 400:");
        List<String> task400Range = data.stream()
                .filter(n -> n.errorNumber > 399 && n.errorNumber < 500)
                .map( n -> n.errorDetail)
                .collect(Collectors.toList());

        System.out.println(task400Range);



        System.out.println("\n\n\nErrors in range of 500:");
        List<String> task500Range = data.stream()
                .filter(n -> n.errorNumber > 499 && n.errorNumber < 600)
                .map( n -> n.errorDetail)
                .collect(Collectors.toList());

        System.out.println(task500Range);






    }

}