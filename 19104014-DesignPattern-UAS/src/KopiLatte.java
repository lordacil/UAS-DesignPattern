public class KopiLatte extends Jenis{

    public KopiLatte(Minuman minuman){
        this.minuman = minuman;
    }

    @Override
    public String getJenis_minuman() {
        return minuman.getJenis_minuman() + " Latte";
    }

    @Override
    public int harga() {
        return minuman.harga() + 15000;
    }
}
