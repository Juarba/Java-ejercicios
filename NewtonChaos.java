import java.awt.Color;

public class Chaos {

    public final double range = 0.001;
    public final Complex four = new Complex(4, 0);
    public final Complex one  = new Complex(1, 0);
    public final Complex three = new Complex(3,0);

    static Color case1(Complex z) {
        final Complex root1 = new Complex(1, 0);
        final Complex root2 = new Complex(-1, 0);
        final Complex root3 = new Complex(0, 1);
        final Complex root4 = new Complex(0, -1);

        for (int i = 0; i < 100; i++) {
            Complex f  = z.times(z).times(z).times(z).minus(one);
            Complex fp = four.times(z).times(z).times(z);
            z = z.minus(f.divides(fp));
            if (z.minus(root1).abs() <= range) return Color.YELLOW;
            if (z.minus(root2).abs() <= range) return Color.BLUE;
            if (z.minus(root3).abs() <= range) return Color.RED;
            if (z.minus(root4).abs() <= range) return Color.GREEN;
        }  
        return Color.BLACK;
    }

    static Color case2(final Complex z) {
        
        final Complex root1 = new Complex(1, 0);
        final Complex root2 = new Complex(-0.5, -0.866);
        final Complex root3 = new Complex(-0.5, 0.866);

        for (int i = 0; i < 100; i++) {
            final Complex f  = z.times(z).times(z).minus(one);
            final Complex fp = three.times(z).times(z);
            z = z.minus(f.divides(fp));
            if (z.minus(root1).abs() <= range) return Color.RED;
            if (z.minus(root2).abs() <= range) return Color.BLUE;
            if (z.minus(root3).abs() <= range) return Color.GREEN;
        }  
        return Color.BLACK;
    }

    public static void main(final String[] args) {
        final int n = Integer.parseInt(args[0]);
        final double xmin   = -1.0;
        final double ymin   = -1.0;
        final double width  =  2.0;
        final double height =  2.0;

        Picture picture = new Picture(n, n);

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                double x = xmin + col * width  / n;
                double y = ymin + row * height / n;
                Complex z = new Complex(x, y);
                Color color = case1(z);
                picture.set(col, n - 1 - row, color);
            }
        }
        picture.show();
    }

}
