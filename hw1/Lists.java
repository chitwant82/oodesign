import java.util.ArrayList;

/**
 * Created by chitwant.singh on 1/24/17.
 */
public class Lists {

    public static void swapLargestAndSecondSmallest(ArrayList<Integer> a) {

        if(a.size() < 3)
            return;

        int sm = a.get(0);
        int ssm = a.get(1);
        int lg = a.get(0);
        for (int i = 2; i < a.size(); i++) {
            if(a.get(i) < sm || a.get(i) < ssm) {
                if (a.get(i) < sm) {
                    ssm = sm;
                    sm = a.get(i);
                }
                else if (a.get(i) < ssm && a.get(i) > sm) {
                    ssm = a.get(i);
                }
            }
            else if (a.get(i) > lg) {
                lg = a.get(i);
            }
        }

        int fIndex = 0;
        int sIndex = 0;
        boolean ssmFound = false;
        boolean lgFound = false;
        for (int j = 0; j < a.size(); j++) {
            if(a.get(j) == ssm || a.get(j) == lg) {
                if (a.get(j) == ssm && !ssmFound) {
                    fIndex = j;
                    ssmFound = true;
                }

                if (a.get(j) == lg && !lgFound) {
                    sIndex = j;
                    lgFound = true;
                }
            }

            if(lgFound && ssmFound) {
                int temp = a.get(fIndex);
                a.set(fIndex, a.get(sIndex));
                a.set(sIndex, temp);
                return;
            }
        }
    }

    public static ArrayList<Integer> list(int... values)
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int v : values) result.add(v);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = list(5, 4, 1, 9, 2, 6);
        swapLargestAndSecondSmallest(a);
        System.out.println(a);
        a = list(1, 4, 1, 9, 2, 6);
        swapLargestAndSecondSmallest(a);
        System.out.println(a);
        a = list(1, 4, 2, 9, 2, 6);
        swapLargestAndSecondSmallest(a);
        System.out.println(a);
        a = list(9, 4, 2, 9, 4, 6);
        swapLargestAndSecondSmallest(a);
        System.out.println(a);
        a = list(1, 4, 1, 4, 1, 4);
        swapLargestAndSecondSmallest(a);
        System.out.println(a);
        a = list(1, 1, 1, 1, 1, 1);
        swapLargestAndSecondSmallest(a);
        System.out.println(a);
        a = list(1);
        swapLargestAndSecondSmallest(a);
        System.out.println(a);
    }
}
