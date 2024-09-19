import java.time.LocalDate;
public class App {
    public static void main(String[] args) throws Exception {
        Pessoa person01 = new Pessoa("Clebinho do Arocha", "51621439526", "cleberhenrique@gmail.ocm", "74998082672", LocalDate.of(2005, 07, 30));
    // Professor, me poderia explicar o movito de ser inválido o cpf?
    // Esse cpf é o exemplo do site da atividade
    System.out.println(person01.getCpf());
    person01.setCpf("14538220620");
    System.out.println(person01.getCpf());

    System.out.println("---------------------------");
    System.out.println(person01.getTelefone());
    person01.setTelefone("89994121107");
    System.out.println(person01.getTelefone());
    person01.setTelefone("89 94121107");
    System.out.println(person01.getTelefone());
    System.out.println("---------------------------");

    person01.exibirDados();
    }
}
