import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
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



    }
}