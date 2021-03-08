package memento;

public class Funcionario {

    protected int id;
    protected String nome;
    protected long salario;

    public Funcionario(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Funcionario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public long getSalario() {
        return salario;
    }

    public Funcionario setSalario(long salario) {
        this.salario = salario;
        return this;
    }

    @Override
    public String toString() {
        return "Funcionário [id=" + id + ", nome=" + nome + ", salário=" + salario + "]";
    }

    public FuncionarioMemento createMemento() {
        return new FuncionarioMemento(id, nome, salario);
    }

    public void restore(FuncionarioMemento memento) {
        if (memento != null) {
            this.id = memento.id;
            this.nome = memento.nome;
            this.salario = memento.salario;
        } else {
            System.err.println("Não é possível restaurar sem um objeto memento.");
        }
    }
}
