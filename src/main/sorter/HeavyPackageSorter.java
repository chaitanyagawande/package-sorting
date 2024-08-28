package sorter;

import model.Package;
import model.PackageType;

public class HeavyPackageSorter implements PackageSorter {

    @Override
    public PackageType sort(Package pkg) {
        if (pkg.getMass() >= 20) {
            return PackageType.SPECIAL;
        }
        return PackageType.STANDARD;
    }
}
