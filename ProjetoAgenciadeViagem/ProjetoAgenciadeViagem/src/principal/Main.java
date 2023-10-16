package principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import principalDAO.ClienteDAO;
import principalDAO.ReservaDAO;
import principalDAO.ViagemDAO;
import principal.Cliente;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        ReservaDAO reservaDAO = new ReservaDAO();
        ViagemDAO viagemDAO = new ViagemDAO();

        while (true) {
            System.out.println("Sistema de Agência de Viagem");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("5. Cadastrar Reserva");
            System.out.println("6. Cadastrar Viagem");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
           

            switch (opcao) {
                case 1:
                    // Cadastrar Cliente na Agência de Viagem
                    Cliente cliente1 = new Cliente();
                    System.out.print("Nome do Cliente: ");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    cliente1.setNome(scanner.next());
                    System.out.print("Número do cpf: ");
                    cliente1.setCpf(scanner.nextInt());
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    System.out.print("Informe a sua nacionalidade: ");
                    cliente1.setNacionalidade(scanner.nextLine());
                    System.out.print("Digite o seu email: ");
                    cliente1.setEmail(scanner.nextLine());
                    System.out.print("Digite o seu número de telefone:");
                    cliente1.setTelefone(scanner.nextInt());
                    clienteDAO.criarCliente(cliente1);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    // Listar de clientes
                    List<Cliente> clientes = clienteDAO.listarCliente();
                    System.out.println("Lista de Clientes:");
                    for (Cliente c : clientes) {
                        System.out.println("Id: " + c.getId() +
                                ", Nome: " + c.getNome());
                    }
                    break;
                case 3:
                    // Atualizar Clientes
                    System.out.print("Id do Cliente para atualização: ");
                    int clienteIdAtualizar = scanner.nextInt();
                    Cliente clienteAtualizar = clienteDAO.buscarCliente(clienteIdAtualizar);
                    if (clienteAtualizar != null) {
                        System.out.print("Novo nome do Cliente: ");
                        scanner.nextLine();
                        clienteAtualizar.setNome(scanner.nextLine());
                        System.out.print("Inserir a sua Nacionalidade: ");
                        clienteAtualizar.setNacionalidade(scanner.nextLine());
                        clienteDAO.atualizarCliente(clienteAtualizar);
                        System.out.println("Cliente atualizado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    // Excluir Cliente
                    System.out.print("Id do Cliente para exclusão: ");
                    int clienteIdExcluir = scanner.nextInt();
                    Cliente clienteExcluir = clienteDAO.buscarCliente(clienteIdExcluir);
                    if (clienteExcluir != null) {
                        clienteDAO.excluirCliente(clienteIdExcluir);
                        System.out.println("Cliente excluído com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
          
                case 5:
                    // Cadastrar Reserva
                    Reserva reserva = new Reserva();
                    System.out.print("Informe o Id do Cliente: ");
                    int clienteIdReserva = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do teclado

                    Cliente clienteReserva = clienteDAO.buscarCliente(clienteIdReserva);
                    if (clienteReserva != null) {
                        reserva.setCliente(clienteReserva);
                        System.out.print("Informe o valor da passagem: ");
                        int valorPassagem = scanner.nextInt();
                        reserva.setValorPassagem(valorPassagem);

                        scanner.nextLine();
                        System.out.print("Informe a data de embarque (yyyy/MM/dd): ");
                        String dataEmbarque = scanner.nextLine();
                        reserva.setDataEmbarque(dataEmbarque);
                        System.out.println("Informe o status da reserva (confirmada ou não confirmada):");
                        String statusReserva = scanner.nextLine();
                        reserva.setStatusReserva(statusReserva);
                        reservaDAO.criarReserva(reserva);

   
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                    
                case 6:
                	// Cadastrar Viagem
                	Viagem viagem1 = new Viagem();
                	System.out.println("Informe o seu nome:");
                	scanner.nextLine();
                	String nomeViagem = scanner.nextLine();
                	viagem1.setNome(nomeViagem); // Defina o nome da viagem
                	System.out.print("Origem e Destino da Viagem: ");
                	String origemDestino = scanner.nextLine(); // Colete a origem e destino da viagem
                	viagem1.setOrigemDestino(origemDestino);
                	System.out.print("Data da Viagem (yyyy/MM/dd): ");
                	String dataString = scanner.next();
                	try {
                	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                	    Date dataViagem = sdf.parse(dataString);
                	    viagem1.setDataViagem(dataViagem);
                	    viagemDAO.criarViagem(viagem1);
                	    System.out.println("Viagem cadastrada com sucesso!");
                	} catch (ParseException e) {
                	    System.out.println("Formato de data inválido. Use yyyy/MM/dd.");
                	}
                	break;


                case 7:
                    // Sair
                    System.out.println("Saindo do sistema...");
                    viagemDAO.fecharConexao();
                    reservaDAO.fecharConexao();
                    clienteDAO.fecharConexao();
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        
    }
    
}


