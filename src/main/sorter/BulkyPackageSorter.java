package sorter;

import model.Package;
import model.PackageType;

public class BulkyPackageSorter implements PackageSorter {

    @Override
    public PackageType sort(Package pkg) {
        boolean isBulky = pkg.getVolume() >= 1000000 || pkg.getWidth() >= 150 || pkg.getHeight() >= 150 || pkg.getLength() >= 150;
        if (isBulky) {
            return PackageType.SPECIAL;
        }
        return PackageType.STANDARD;
    }
}
