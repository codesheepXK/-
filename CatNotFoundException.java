public class CatNotFoundException extends RuntimeException{

    public CatNotFoundException(int num){
        if(num<=0){
            System.out.println("No cat to rua");
        }
    }
}
