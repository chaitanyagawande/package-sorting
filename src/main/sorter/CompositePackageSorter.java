package sorter;

import model.Package;
import model.PackageType;

import java.util.List;

public class CompositePackageSorter implements PackageSorter {

    private List<PackageSorter> sorters;

    public CompositePackageSorter(List<PackageSorter> sorters) {
        this.sorters = sorters;
    }

    @Override
    public PackageType sort(Package pkg) {
        boolean isBulky = false;
        boolean isHeavy = false;

        for (PackageSorter sorter : sorters) {
            PackageType result = sorter.sort(pkg);
            if (result == PackageType.SPECIAL) {
                if (sorter instanceof BulkyPackageSorter) {
                    isBulky = true;
                } else if (sorter instanceof HeavyPackageSorter) {
                    isHeavy = true;
                }
            }
        }

        if (isBulky && isHeavy) {
            return PackageType.REJECTED;
        } else if (isBulky || isHeavy) {
            return PackageType.SPECIAL;
        }
        return PackageType.STANDARD;
    }
}
