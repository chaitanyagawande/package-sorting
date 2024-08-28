package test;

import model.Package;
import model.PackageType;
import sorter.BulkyPackageSorter;
import sorter.CompositePackageSorter;
import sorter.HeavyPackageSorter;
import sorter.PackageSorter;

import java.util.Arrays;

public class PackageSorterTest {

    public static void main(String[] args) {
        PackageSorter bulkySorter = new BulkyPackageSorter();
        PackageSorter heavySorter = new HeavyPackageSorter();
        PackageSorter compositeSorter = new CompositePackageSorter(Arrays.asList(bulkySorter, heavySorter));

        testStandardPackage(compositeSorter);
        testBulkyPackage(compositeSorter);
        testHeavyPackage(compositeSorter);
        testRejectedPackage(compositeSorter);
        testEdgeCaseJustUnderBulkyAndHeavy(compositeSorter);

        System.out.println("All tests passed.");
    }

    private static void testStandardPackage(PackageSorter sorter) {
        Package pkg = new Package(100, 100, 99, 10);
        PackageType result = sorter.sort(pkg);
        assertResult("STANDARD", result);
    }

    private static void testBulkyPackage(PackageSorter sorter) {
        Package pkg = new Package(200, 50, 50, 10);
        PackageType result = sorter.sort(pkg);
        assertResult("SPECIAL", result);
    }

    private static void testHeavyPackage(PackageSorter sorter) {
        Package pkg = new Package(100, 100, 99, 25);
        PackageType result = sorter.sort(pkg);
        assertResult("SPECIAL", result);
    }

    private static void testRejectedPackage(PackageSorter sorter) {
        Package pkg = new Package(200, 200, 200, 25);
        PackageType result = sorter.sort(pkg);
        assertResult("REJECTED", result);
    }

    private static void testEdgeCaseJustUnderBulkyAndHeavy(PackageSorter sorter) {
        Package pkg = new Package(49, 49, 49, 19.9);
        PackageType result = sorter.sort(pkg);
        assertResult("STANDARD", result);
    }

    private static void assertResult(String expected, PackageType result) {
        if (!expected.equals(result.name())) {
            throw new AssertionError("Test failed! Expected: " + expected + ", but got: " + result);
        }
    }
}
