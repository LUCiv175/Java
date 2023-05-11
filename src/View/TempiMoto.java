package View;

public class TempiMoto {
    private int id;
    private String nome;

    public TempiMoto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {//nella visualizzazione della lista il compilatore usa il metodo toString perciò lo scriviamo passando il nome e non l'oggetto
        return nome;
    }
}
