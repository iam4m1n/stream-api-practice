public class Error {

    public int errorNumber;
    public String errorDetail = "";

    public Error(int x, String[] str){
        errorNumber = x;
        for (int i = 1; i < str.length; i++) {
            errorDetail += str[i];
        }
    }

    public String getErrorDetail(){
        return errorDetail;
    }



}
