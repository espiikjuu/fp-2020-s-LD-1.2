public class Numbers{
    public static Set<Integer> factors(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int square_root = (int) Math.sqrt(n) + 1;
        for (int i = 1; i < square_root; i++) {
            if (n % i == 0 && square_root*square_root != n){
                set.add(i);
                set.add(n/i);
            }
            if (n % i == 0 && square_root*square_root == n){
                set.add(i);
            }
        }
        return set;
    }

    public static String check(int n) {

        int sum = factors(n).stream().reduce((tot, x) -> tot + x).orElse(1) - n;

        if (sum == n) {
            return "perfect";
        }
        else if (sum > n) {
            return "abundant";
        }
        return "deficient";

    }

    public static void main (String[] args) {
        System.out.println(check(496));
    }

}