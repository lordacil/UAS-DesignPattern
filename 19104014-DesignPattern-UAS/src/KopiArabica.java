public class KopiArabica extends Jenis{

    public KopiArabica(Minuman minuman){
        this.minuman = minuman;
    }

    @Override
    public String getJenis_minuman() {
        return minuman.getJenis_minuman() + " Arabica";
    }

    @Override
    public int harga() {
        return minuman.harga() + 20000;
    }
}
