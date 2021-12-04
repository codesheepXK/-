import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MyCatCafe implements CatCafe {
    private double balance;
    private final ArrayList<Cat> cats;
    private final ArrayList<Customer> customers;

    public MyCatCafe(double balance, ArrayList<Cat> cats, ArrayList<Customer> customers) {
        this.balance = balance;
        this.cats = cats;
        this.customers = customers;
    }

    public void BuyNewCats(Cat cat) {
        if (cat.getPrice() <= balance) {
            cats.add(cat);
            balance -= cat.getPrice();
        } else {
            try {
                throw new InsufficientBalanceException("No money to pay");
            } catch (InsufficientBalanceException e) {
                e.printStackTrace();
            }
        }

    }

    public void Close() {
        //不知道怎么实现
    }

    public void Welcome(Customer customer) {
        if (cats.isEmpty()) {
            try {
                throw new CatNotFoundException(0);
            } catch (CatNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            customers.add(customer);
            Random random = new Random();
            for (int i = 1; i <= customer.getRua(); i++) {
                int index = random.nextInt(cats.size());
                System.out.println(cats.get(index).toString());
            }
            balance += customer.getRua() * 15;
        }
    }
}
