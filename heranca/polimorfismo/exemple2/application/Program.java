package heranca.polimorfismo.exemple2.application;

import heranca.polimorfismo.exemple2.entites.ImportedProduct;
import heranca.polimorfismo.exemple2.entites.Product;
import heranca.polimorfismo.exemple2.entites.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int x = sc.nextInt();

        for(int i=1; i <= x; i++) {
            System.out.print("PRODUCT #" + i + " DATA:");
            System.out.print("\nCommon, used, imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if(ch == 'c') {
                Product product = new Product(name, price);
                productList.add(product);
            } else if (ch == 'u') {
                System.out.print("Manufacture data: ");
                Date manu = sdf.parse(sc.next());

                Product product = new UsedProduct(name, price, manu);
                productList.add(product);
            } else if (ch == 'i') {
                System.out.print("Customs fee: ");
                Double fee = sc.nextDouble();

                Product product = new ImportedProduct(name, price, fee);
                productList.add(product);
            }
        }

        System.out.println("\nPRICE TAGS:");
        for(Product p : productList) {
            System.out.println(p.priceTag());
        }

        sc.close();

    }

}
