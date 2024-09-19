import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    String nome;
    String cpf;
    String email;
    String telefone;
    LocalDate dataNascimento;
    //Contrutores
    public Pessoa(String nome, String cpf, String email, String telefone, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        //Telefone
        char[] caracteres = telefone.toCharArray();
        boolean SaoDigitos = true;
        for (int i = 0; i < caracteres.length; i++){
            SaoDigitos &= Character.isDigit(caracteres[i]);
        }
        if(SaoDigitos && caracteres.length == 11){
            this.telefone = telefone;
        }
        else{
            System.out.println("Telefone inválido!");
        }

        //E-mail
        char[] eMail = email.toCharArray();
        int contArroba = 0;
        for(int i = 0; i < eMail.length; i++){
             if(eMail[i] == '@'){
                 contArroba++;
             }
        }
        if (contArroba == 1){
         this.email = email;
        }
        else{
         System.out.println("e-mail inválido!");
        }
        
        // CPF
        char[] n_cpf = cpf.toCharArray();
        boolean validador = true;
        int somatorio_digitos_cpf = 0;
        int multiplicador_digitos = 10;
        int primerio_digito_verificador = 0;
        int segundo_digito_verificador = 0;
        for (int i = 0; i < n_cpf.length; i++){
            validador &= Character.isDigit(n_cpf[i]);
        }

        if (validador && n_cpf.length == 11){
            // Primero digito validador
            for (int i = 0; i < 9; i++){
                somatorio_digitos_cpf += (n_cpf[i] - '0') * multiplicador_digitos;
                multiplicador_digitos --;
            }
            primerio_digito_verificador = somatorio_digitos_cpf % 11;
            if (primerio_digito_verificador >= 10){
                primerio_digito_verificador = 0;
            }
            // Segundo digito validador
            somatorio_digitos_cpf = 0;
            multiplicador_digitos = 11;
            for (int i = 0; i < 10; i++){
                somatorio_digitos_cpf += (n_cpf[i] - '0') * multiplicador_digitos;
                multiplicador_digitos --;
            }
            segundo_digito_verificador = somatorio_digitos_cpf % 11;
            if (segundo_digito_verificador >= 10){
                segundo_digito_verificador = 0;
            }
        }
        // Comparação de digitos validadores;
        if ((n_cpf[9] - '0') == primerio_digito_verificador && (n_cpf[10] - '0') == segundo_digito_verificador){
            this.cpf = cpf;
        }else{
            System.out.println("CPF inválido!");
        }
        
    }
// Getters
    public int getIdade(){
        LocalDate data_atual  = LocalDate.now();
        Period diferença = Period.between(this.dataNascimento, data_atual);
        return diferença.getYears();
    }
    public String getNome(){
        return this.nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public String getEmail(){
        return this.email;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public LocalDate getDataNascimento(){
        return this.dataNascimento;
    }

//Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        char[] n_cpf = cpf.toCharArray();
        boolean validador = true;
        int somatorio_digitos_cpf = 0;
        int multiplicador_digitos = 10;
        int primerio_digito_verificador = 0;
        int segundo_digito_verificador = 0;
        for (int i = 0; i < n_cpf.length; i++){
            validador &= Character.isDigit(n_cpf[i]);
        }

        if (validador && n_cpf.length == 11){
            // Primero digito validador
            for (int i = 0; i < 9; i++){
                somatorio_digitos_cpf += (n_cpf[i] - '0') * multiplicador_digitos;
                multiplicador_digitos --;
            }
            primerio_digito_verificador = somatorio_digitos_cpf % 11;
            if (primerio_digito_verificador >= 10){
                primerio_digito_verificador = 0;
            }
            // Segundo digito validador
            somatorio_digitos_cpf = 0;
            multiplicador_digitos = 11;
            for (int i = 0; i < 10; i++){
                somatorio_digitos_cpf += (n_cpf[i] - '0') * multiplicador_digitos;
                multiplicador_digitos --;
            }
            segundo_digito_verificador = somatorio_digitos_cpf % 11;
            if (segundo_digito_verificador >= 10){
                segundo_digito_verificador = 0;
            }
        }
        // Comparação de digitos validadores;
        if ((n_cpf[9] - '0') == primerio_digito_verificador && (n_cpf[10] - '0') == segundo_digito_verificador){
            this.cpf = cpf;
        }else{
            System.out.println("CPF inválido!");
        }

    }
    // Set email:
    public void setEmail(String email){
       char[] eMail = email.toCharArray();
       int contArroba = 0;
       for(int i = 0; i < eMail.length; i++){
            if(eMail[i] == '@'){
                contArroba++;
            }
       }
       if (contArroba == 1){
        this.email = email;
       }
       else{
        System.out.println("e-mail inválido!");
       }
    }
    // Fim Set email;

    public void setTelefone(String telefone){
        char[] caracteres = telefone.toCharArray();
        boolean SaoDigitos = true;
        for (int i = 0; i < caracteres.length; i++){
            SaoDigitos &= Character.isDigit(caracteres[i]);
        }
        if(SaoDigitos && caracteres.length == 11){
            this.telefone = telefone;
        }
        else{
            System.out.println("Telefone inválido!");
        }
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    // Exibir Dados:
    public void exibirDados(){
        System.out.println("Dados Pessoais:");
        System.out.println("- Nome: " + this.nome);
        System.out.println("- CPF: " + this.cpf);
        System.out.println("- Email: " + this.email);
        System.out.println("- Idade: " + this.getIdade());
    }
}
