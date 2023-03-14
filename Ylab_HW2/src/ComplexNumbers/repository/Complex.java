package ComplexNumbers.repository;

public class Complex {

    private double mRe;
    private double mIm;

    public double getmRe() {
        return mRe;
    }

    public double getmIm() {
        return mIm;
    }

    public Complex(double re, double im){
        this.mIm = im;
        this.mRe = re;
    }


    @Override
    public String toString() {
        if (mIm == 0) return mRe + "";
        if (mRe == 0) return mIm + "i";
        if (mIm <  0) return mRe + " - " + (-mIm) + "i";
        return mRe + " + " + mIm + "i";
    }
}
