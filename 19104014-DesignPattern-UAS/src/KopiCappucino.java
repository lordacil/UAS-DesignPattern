public class KopiCappucino extends Jenis{
    public KopiCappucino(Minuman minuman){
        this.minuman = minuman;
    }

    @Override
    public String getJenis_minuman() {
        return minuman.getJenis_minuman() + " Cappucino";
    }

    @Override
    public int harga() {
        return minuman.harga() + 20000;
    }
}
