import model.Package;
import model.PackageType;
import sorter.BulkyPackageSorter;
import sorter.CompositePackageSorter;
import sorter.HeavyPackageSorter;
import sorter.PackageSorter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PackageSorter bulkySorter = new BulkyPackageSorter();
        PackageSorter heavySorter = new HeavyPackageSorter();

        PackageSorter compositeSorter = new CompositePackageSorter(Arrays.asList(bulkySorter, heavySorter));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the package width (cm): ");
            int width = scanner.nextInt();

            System.out.println("Enter the package height (cm): ");
            int height = scanner.nextInt();

            System.out.println("Enter the package length (cm): ");
            int length = scanner.nextInt();

            System.out.println("Enter the package mass (kg): ");
            double mass = scanner.nextDouble();

            Package pkg = new Package(width, height, length, mass);

            PackageType result = compositeSorter.sort(pkg);

            System.out.println("Package should go to: " + result);
        }
    }
}
