public class KopiIced extends Jenis{
    public KopiIced(Minuman minuman){
        this.minuman = minuman;
    }

    @Override
    public String getJenis_minuman() {
        return minuman.getJenis_minuman() + " Iced";
    }

    @Override
    public int harga() {
        return minuman.harga() + 13000;
    }
}
