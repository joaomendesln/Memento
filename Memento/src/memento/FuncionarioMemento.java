package memento;

public class FuncionarioMemento {

        protected int id;
        protected String nome;
        protected long salario;

        public FuncionarioMemento(int id, String nome, long salario) {
            super();
            this.id = id;
            this.nome = nome;
            this.salario = salario;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public FuncionarioMemento setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public long getSalario() {
            return salario;
        }

        public FuncionarioMemento setSalario(long salario) {
            this.salario = salario;
            return this;
        }

        @Override
        public String toString() {
            return "Funcionário [id=" + id + ", nome=" + nome + ", salário=" + salario + "]";
        }
}
