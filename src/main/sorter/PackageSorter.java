package sorter;

import model.Package;
import model.PackageType;

public interface PackageSorter {
    PackageType sort(Package pkg);
}
