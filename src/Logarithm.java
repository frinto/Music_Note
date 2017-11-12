public class Logarithm
{
    public Logarithm()
    {
        
    }
    
    public static double logbase( double a, double b )
    {
        return Math.log(a) / Math.log(b);
    }

    public static double log2( double a )
    {
        return logbase(a,2);
    }
    
}
