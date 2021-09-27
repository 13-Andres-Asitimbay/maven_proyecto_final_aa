package proyecto.finall.andres.asitimbay;

import java.util.Scanner;
import java.time.LocalDate;

public class MainSistemaMetrocard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in); // teclado para String
		Scanner teclado2 = new Scanner(System.in); // teclado para int
		int opcion;
		String seleccion;
		int contador = 0;
		LocalDate diaHoy = LocalDate.now();
		LocalDate diaFin;
		Auto coleccion[] = new Auto[100];
		do {
			System.out.println("METROCARD");
			System.out.println("  1. Clientes");
			System.out.println("  2. Empleados");
			System.out.println("  3. SALIR");
			opcion = teclado2.nextInt();
			System.out.println(" ");

			switch (opcion) {
			case 1: // 1. Clientes
				System.out.println("a) Consultar autos");
				System.out.println("b) Reservar auto");
				seleccion = teclado.nextLine();
				System.out.println(" ");
				switch (seleccion) {
				case "a": // a) Consultar autos
					System.out.println("Por favor ingrese el modelo y/o marca del auto:");
					String marcaModelo = teclado.nextLine();
					System.out.println("Autos: ");
					for (int i = 0; i <= coleccion.length; i++) {
						Auto auto = coleccion[i];
						boolean encontro = auto.getModelo().contains(marcaModelo);
						boolean encontro2 = auto.getMarca().contains(marcaModelo);
						
						if (encontro == true || encontro2 == true) {
							System.out.println("Placa: " + auto.getPlaca() + " - Modelo: " + auto.getModelo() + " - Marca: " + auto.getMarca() + " - Año: " + auto.getAnioDeFabricacion() + " - Fecha de entrega: " + auto.getFechaEntrega());
							
						} else {
							System.out.println("No se ha podido encontrar el auto...");
							
						}

					}
					break;

				case "b": // b) Reservar auto
					System.out.println("Ingrese la placa del auto a reservar: ");
					String placaReserva = teclado.nextLine();
					System.out.println("Ingrese su cédula por favor: ");
					String cedulaReserva = teclado.nextLine();
					for (int i = contador ; contador == i; i++) {
						Auto cliente = new Auto();
						cliente.setCedulaCliente(cedulaReserva);
						cliente.getCedulaCliente();
						coleccion[i] = cliente;
					}
					contador = contador + 1;
					
					for (int i = 0; i <= coleccion.length; i++) {
						Auto auto = coleccion[i];
						boolean encontro = auto.getPlaca().contains(placaReserva);
						if (encontro == true) {
							boolean encontro2 = auto.getEstado().equals("Disponible");
							if (encontro2 == true) {
								auto.setEstado("Reservado");
								diaFin = diaHoy.plusDays(2);
								auto.setFechaEntrega(diaFin);
								auto.getFechaEntrega();
								coleccion[i] = auto;
								System.out.println("Su auto ha sido reservado correctamente, pase a retirarlo al patio de autos por favor.");
								
							} else {
								System.out.println("El auto que solicitó no está disponible...");
								
							}
							
						} else {
							System.out.println("No se ha podido encontrar el auto...");
							
						}
					}
					break;
					
					default:
						System.out.println("OPCION INVALIDA");
						break;
				}
				break;

			case 2: // 2. Empleados
				System.out.println("a) Ingresar un auto");
				System.out.println("b) Alquilar un auto");
				System.out.println("c) Aplazar fecha de entrega");
				seleccion = teclado.nextLine();
				System.out.println(" ");
				if (contador >= 0 || contador < 100) {
					switch (seleccion) {
					case "a":
						System.out.println("Ingrese la placa del auto: ");
						String placa = teclado.nextLine();
						System.out.println("Ingrese el modelo del auto: ");
						String modelo = teclado.nextLine();
						System.out.println("Ingrese la marca del auto: ");
						String marca = teclado.nextLine();
						System.out.println("Ingrese el año de fabricación del auto: ");
						String anioFabricacion = teclado.nextLine();
						System.out.println("Ingrese el país de fabricación del auto: ");
						String paisFabricacion = teclado.nextLine();
						System.out.println("Ingrese el cilindraje del auto: ");
						int cilindraje = teclado2.nextInt();
						System.out.println("Ingrese el avalúo del auto: ");
						int avaluo = teclado2.nextInt();
						System.out.println(" ");
						System.out.println("Seleccione el tipo de auto: ");
						System.out.println("   I) Automóvil");
						System.out.println("  II) Camioneta");
						String seleccion2 = teclado.nextLine();
						System.out.println(" ");
						if (seleccion2.equals("I")) {
							System.out.println("Ingrese el número de puertas: ");
							int numeroPuertas = teclado2.nextInt();
							for (int i = contador ; contador == i; i++) {
								Automovil automovil = new Automovil();
								automovil.setPlaca(placa);
								automovil.setModelo(modelo);
								automovil.setMarca(marca);
								automovil.setAnioDeFabricacion(anioFabricacion);
								automovil.setPaisFabricacion(paisFabricacion);
								automovil.setCilindraje(cilindraje);
								automovil.setAvaluo(avaluo);
								automovil.setNumeroPuertas(numeroPuertas);
								coleccion[i] = automovil;
							}
							contador = contador + 1;

						} else if (seleccion2.equals("II")) {
							System.out.println("Ingrese el peso que soporta: ");
							int pesoQueSoporta = teclado2.nextInt();
							for (int i = contador ; contador == i; i++) {
								Camioneta camioneta = new Camioneta();
								camioneta.setPlaca(placa);
								camioneta.setModelo(modelo);
								camioneta.setMarca(marca);
								camioneta.setAnioDeFabricacion(anioFabricacion);
								camioneta.setPaisFabricacion(paisFabricacion);
								camioneta.setCilindraje(cilindraje);
								camioneta.setAvaluo(avaluo);
								camioneta.setPesoQueSoporta(pesoQueSoporta);
								coleccion[i] = camioneta;
							}
							contador = contador + 1;
							System.out.println("Datos del auto guardados con exito.");
							System.out.println(" ");

						} else if (!seleccion2.equals("I") || !seleccion2.equals("II")) {
							System.out.println("OPCIÓN INVALIDA");
							
						}
						break;

					case "b":
						System.out.println("Ingrese la placa del auto: ");
						String placaAuto = teclado.nextLine();
						for (int i = 0; i <= coleccion.length; i++) {
							Auto auto = coleccion[i];
							boolean encontro = auto.getPlaca().contains(placaAuto);
							if (encontro == true) {
								boolean encontro2 = auto.getEstado().equals("Reservado");
								if (encontro2 == true) {
									System.out.println("Auto = Placa: " + auto.getPlaca() + " - Modelo: " + auto.getModelo() + " - Estado: " + auto.getEstado() + " - Fecha de Entrega: " + auto.getFechaEntrega() + " - Reservado por: " + auto.getCedulaCliente());
									System.out.println(" ");
									System.out.println("¿Desea alquilarlo?");
									System.out.println("   I) Alquilar");
									System.out.println("  II) No Alquilar");
									String opcion3 = teclado.nextLine();
									switch (opcion3) {
									case "I":
										auto.setEstado("Alquilado");
										diaFin = diaHoy.plusDays(2);
										auto.setFechaEntrega(diaFin);
										System.out.println("El auto debe ser entregado el: " + auto.getFechaEntrega());
										break;
										
									case "II":
										System.out.println("El auto no ha sido alquilado");
										break;
										
									default:
										System.out.println("OPCIÓN INVALIDA");
										break;
									}
									
								} else {
									System.out.println("El auto que solicitó no está reservado...");
									
								}
								
							} else {
								System.out.println("El auto que solicitó no está disponible...");
								
							}
							
						}
						break;

					case "c":
						System.out.println("Ingrese la placa del auto por favor: ");
						String placaBuscar = teclado.nextLine();
						System.out.println("Ingrese la cédula del cliente por favor: ");
						String cedulaBuscar = teclado.nextLine();
						System.out.println("Autos: ");
						for (int i = 0; i <= coleccion.length; i++) {
							Auto auto = coleccion[i];
							boolean encontro = auto.getPlaca().contains(placaBuscar);
							if (encontro == true) {
								boolean encontro2 = auto.getCedulaCliente().contains(cedulaBuscar);
								if (encontro2 == true) {
									System.out.println("Placa: " + auto.getPlaca() + " - Modelo: " + auto.getModelo() + " - Estado: " + auto.getEstado() + " - Fecha de Entrega: " + auto.getFechaEntrega() + " - Alquilado a: " + auto.getCedulaCliente());
									System.out.println(" ");
									System.out.println("¿Desea aplazar la fecha de entrega?");
									System.out.println("   I) Aplazar");
									System.out.println("  II) No Aplazar");
									String opcion2 = teclado.nextLine();
									switch (opcion2) {
									case "I":
										LocalDate diaActual = auto.getFechaEntrega();
										LocalDate diaNuevo = diaActual.plusDays(2);
										auto.setFechaEntrega(diaNuevo);
										auto.getFechaEntrega();
										coleccion[i] = auto;
										break;
										
									case "II":
										System.out.println("Se ha denegado la petición.");
										break;
										
									default:
										System.out.println("OPCIÓN INVALIDA");
										break;
									}
									
								} else {
									System.out.println("No se ha encontrado su cédula...");
									
								}
								
							} else {
								System.out.println("No se ha podido encontrar el auto...");
								
							}
						}
						break;
						
						default:
							System.out.println("OPCIÓN INVALIDA");
							break;
					}
					
				}
				break;

			case 3: // 3. SALIR
				System.out.println("Un gusto haberlo atendido...");
				break;

			default: // Opcion inválida
				System.out.println("OPCIÓN INVALIDA");
				break;
			}
		} while (opcion != 3);

	}

}
