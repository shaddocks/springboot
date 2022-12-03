package algorithm;

import java.util.ArrayList;
import java.util.List;

public class AllAlgorithm {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    private void combineHelper(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < n - (k - path.size()) + 1; ++i) {
            path.add(i);
            combineHelper(n, k, i +  1);
            path.remove(path.size() - 1);
        }
    }
}
