import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.LockSupport;

public class Test {
    static Thread t1=null,t2=null;
    public static void main(String[] args) {
        //创建猫数组
        LocalDate today =LocalDate.now();
        Cat[] cats = new Cat[]{
                new OrangeCat("星期一", 3, true, false),
                new OrangeCat("星期二", 2, false, true),
                new BlackCat("星期三", 1, false)
        };
        //用来购买的猫猫样本
        BlackCat blackCat = new BlackCat("星期四", 3, true);
        OrangeCat orangeCat = new OrangeCat("星期五", 2, false, true);
        //创建顾客样本
        Customer customer1 = new Customer("吴彦祖", 10, today);
        Customer customer2 = new Customer("彭于晏", 5, today);
        ArrayList<Customer> customerList = new ArrayList<>();

        //假设本来就有猫(正常能rua)
        ArrayList<Cat> catList = new ArrayList<>(Arrays.asList(cats));
        //创建CatCafe样本
        MyCatCafe myCatCafe = new MyCatCafe(1000, catList, customerList);
        myCatCafe.Welcome(customer1);
        myCatCafe.BuyNewCats(blackCat);
        myCatCafe.Welcome(customer2);
        myCatCafe.BuyNewCats(orangeCat);


// //假设本来没有猫（用来测试CatNotFoundException异常）
// ArrayList<Cat> catList = new ArrayList<>();
// MyCatCafe myCatCafe=new MyCatCafe(400,catList,customerList);
// //第一次没有猫，会有CatNotFoundException异常
// myCatCafe.Welcome(customer1);
// //买猫时第二只钱不够会抛出异常
// myCatCafe.BuyNewCats(blackCat);
// myCatCafe.BuyNewCats(orangeCat);
// //招待完钱就够买猫了
// myCatCafe.Welcome(customer1);
// myCatCafe.BuyNewCats(orangeCat);

        //第三题
        String re = "\\d{8,10}@[q][q].[c][o][m]";
        String temp1= "2345678qq.com";
        String temp2= "2345678@qq.com";
        String temp3= "234567890@qq.com";
        String temp4= "2345678@q.com";
        System.out.println(temp1.matches(re));
        System.out.println(temp2.matches(re));
        System.out.println(temp3.matches(re));
        System.out.println(temp4.matches(re));
        int arr1[] = {1, 3, 5, 7, 9}, arr2[] = {2, 4, 6, 8, 10};
        multiRun(arr1, arr2);
    }

    public static void multiRun(int[] num1, int[] num2) {
         t1=new Thread(){
            public void run(){
                for (int  num: num1) {
                    System.out.println("线程1 "+num); //t1进先打印

                    LockSupport.unpark(t2); //唤醒t2
                    LockSupport.park(); // t1阻塞
                }
            }
        };
         t2=new Thread(){
            public void run() {
                for (int num : num2) {
                    LockSupport.park(); //要先打印数字， 所以这直接阻塞 唤醒t1后来到这里又阻塞， 等打印数字后再唤醒它
                    System.out.println("线程2 "+num); //被唤醒后打印字母
                    LockSupport.unpark(t1); //唤醒t1
                }
            }
        };
        t2.start();
        t1.start();
    }
}
