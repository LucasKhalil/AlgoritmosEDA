package Algoritmos;

public class RecursiveHashTable<T> {

    private T[] content;
    private int order;
    private int size;

    public RecursiveHashTable(int order) {
        this.content = (T[]) new Aluno[10];
        this.order = order;
        this.size = 0;
    }

    public void add(String newCode, String newName) {
        if (newCode.length() != this.order) {
            throw new IndexOutOfBoundsException("CÓDIGO PASSADO INVÁLIDO, NÚMERO DE CARACTERES (" + newCode.length()
                    + ") DIFERE DA ORDEM (" + this.order + ")");
        }
        int mat = Integer.valueOf(newCode);
        Aluno newAluno = new Aluno(mat, newName);
        this.add(newAluno);
    }

    public void add(Aluno newAluno) {
        int[] v = newAluno.getContent();
        int position = v[v.length - order];
        if (this.content[position] == null) {
            this.content[position] = (T) newAluno;
        } else if (this.content[position] instanceof RecursiveHashTable) {
            RecursiveHashTable newTable = (RecursiveHashTable) this.content[position];
            newTable.add(newAluno);
            this.content[position] = (T) newTable;
        } else if (newAluno.equals((Aluno) this.content[position])) {
            this.content[position] = (T) newAluno;
            return;
        } else {
            RecursiveHashTable newTable = new RecursiveHashTable(this.order - 1);
            newTable.add((Aluno) this.content[position]);
            newTable.add(newAluno);
            this.content[position] = (T) newTable;
        }
    }

    public Aluno getAluno(int matricula) { // DEVE SER O(1)
        String[] arr = String.valueOf(matricula).split("");
        int[] v = new int[arr.length];
        for (int i = 0; i < arr.length; i++) { // << Isto não é O(1)
            v[i] = Integer.valueOf(arr[i]);
        }
        int position = v[v.length - this.order];
        if (this.content[position] == null) {
            return null;
        }
        if (this.content[position] instanceof Aluno) {
            Aluno aluno = (Aluno) this.content[position];
            if (aluno.getMatricula() == matricula) {
                return aluno;
            }
            return null;
        }
        RecursiveHashTable table = (RecursiveHashTable) this.content[position];
        return table.getAluno(matricula);
    }

    public void remove(int matricula) { // DEVE SER O(1)
        String[] arr = String.valueOf(matricula).split("");
        int[] v = new int[arr.length];
        for (int i = 0; i < arr.length; i++) { // << Não é O(1)
            v[i] = Integer.valueOf(arr[i]);
        }
        int position = v[v.length - this.order];
        if (this.content[position] == null) {
            return;
        }
        if (this.content[position] instanceof Aluno) {
            Aluno aluno = (Aluno) this.content[position];
            if (aluno.getMatricula() == matricula) {
                this.content[position] = null;
                return;
            }
            return;
        }
        RecursiveHashTable table = (RecursiveHashTable) this.content[position];
        table.remove(matricula);

    }

    public String toString() {
        String toReturn = "";
        for (int i = 0; i < 10; i++) {
            if (this.content[i] == null)
                continue;
            toReturn += "[LINHA " + i + " " + this.content[i] + "]";
        }
        return toReturn;
    }
}

class Aluno {
    private int matricula;
    private String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public boolean equals(Object n) {
        if (n == null) {
            return false;
        }
        if (!(n instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) n;
        if (aluno.getMatricula() != this.matricula) {
            return false;
        }
        return true;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public int[] getContent() {
        String[] arr = String.valueOf(this.matricula).split("");
        int[] toReturn = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            toReturn[i] = Integer.valueOf(arr[i]);
        }
        return toReturn;
    }

    public String getNome() {
        return this.nome;
    }

    public String toString() {
        return this.nome;
    }
}
