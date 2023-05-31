public class Main {
    class Paciente {
    private String nome;
    private String cpf;
    private int prioridade;

    public Paciente(String nome, String cpf, int prioridade) {
        this.nome = nome;
        this.cpf = cpf;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getPrioridade() {
        return prioridade;
    }
}

class GestaoHospital {
    private Queue<Paciente> filaSevero;
    private Queue<Paciente> filaModerado;
    private Queue<Paciente> filaLeve;
    private Queue<Paciente> filaNormal;

    public GestaoHospital() {
        filaSevero = new LinkedList<>();
        filaModerado = new LinkedList<>();
        filaLeve = new LinkedList<>();
        filaNormal = new LinkedList<>();
    }

    public void adicionarPaciente(String nome, String cpf, int prioridade) {
        Paciente paciente = new Paciente(nome, cpf, prioridade);
        switch (prioridade) {
            case 3:
                filaSevero.add(paciente);
                break;
            case 2:
                filaModerado.add(paciente);
                break;
            case 1:
                filaLeve.add(paciente);
                break;
            default:
                filaNormal.add(paciente);
                break;
        }
    }

    public Paciente atenderProximoPaciente() {
        if (!filaSevero.isEmpty()) {
            return filaSevero.poll();
        } else if (!filaModerado.isEmpty()) {
            return filaModerado.poll();
        } else if (!filaLeve.isEmpty()) {
            return filaLeve.poll();
        } else if (!filaNormal.isEmpty()) {
            return filaNormal.poll();
        } else {
            return null;
        }
    }

    public int getNumeroPacientesNaFila() {
        return filaSevero.size() + filaModerado.size() + filaLeve.size() + filaNormal.size();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestaoHospital gestaoHospital = new GestaoHospital();

        while (true) {
            System.out.println("------ Menu ------");
            System.out.println("1. Adicionar paciente");
            System.out.println("2. Atender próximo paciente");
            System.out.println("3. Exibir número de pacientes na fila");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF do paciente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Prioridade do paciente (0 - normal, 1 - leve, 2 - moderado, 3 - severo): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();
                    gestaoHospital.adicionarPaciente(nome, cpf, prioridade);
                    System.out.println("Paciente adicionado com sucesso!");
                    break;
                case 2:
                    Paciente paciente = gestaoHospital.atenderProximoPaciente();
                    if (paciente != null) {
                        System.out.println("Paciente atendido:");
                        System.out.println("Nome: " + paciente.getNome());
                        System.out.println("CPF: " + paciente.getCpf());
                        System.out.println("Prioridade: " + paciente
