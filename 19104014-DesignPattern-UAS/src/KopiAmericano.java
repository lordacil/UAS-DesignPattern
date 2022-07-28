public class KopiAmericano extends Jenis{
    public KopiAmericano(Minuman minuman){
        this.minuman = minuman;
    }

    @Override
    public String getJenis_minuman() {
        return minuman.getJenis_minuman() + " Americano";
    }

    @Override
    public int harga() {
        return minuman.harga() + 22000;
    }
}
