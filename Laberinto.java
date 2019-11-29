public class Main {

	public static void main(String[] args) {
	    
		char[][] laberinto = 
			{
					{'#','#','#','#','#','#','#','#','#','#', '#','#','#','#','#','#','#','#','#','#'},
					{'#',' ',' ',' ',' ',' ',' ',' ',' ',' ', ' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
					{'#',' ','#',' ','#',' ','#','#','#','#', '#','#','#','#','#','#','#','#',' ','#'},
					{'#',' ','#',' ','#',' ','#','#','#','#', '#','#','#','#','#','#','#','#',' ','#'},
					{'#','#','#',' ','#',' ','#','#','#',' ', '#','#','#','#','#','#','#','#',' ','#'},
					{'#','#','#',' ','#',' ','#','#','#',' ', '#','#','#','#','#','#','#','#',' ','#'},
					{'#',' ',' ',' ','#',' ','#','#','#',' ', '#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
					{'#',' ','#','#','#',' ','#','#','#',' ', '#',' ','#','#','#',' ','#','#',' ','#'},
					{'#',' ','#','#','#',' ','#','#','#',' ', ' ',' ',' ','#','#',' ','#','#',' ','#'},
					{'#',' ',' ',' ','#',' ','#','#','#',' ', '#','#',' ','#','#',' ','#','#',' ','#'},
					{'#','#','#','#','#',' ','#','#','#',' ', ' ','#',' ','#','#',' ','#','#',' ','#'},
					{'#','#',' ',' ','#',' ','#',' ',' ',' ', ' ','#',' ','#','#',' ',' ','#',' ','#'},
					{'#',' ','#',' ','#',' ','#',' ','#','#', ' ','#',' ','#','#',' ','#','#',' ','#'},
					{'#',' ','#',' ','#',' ','#',' ','#','#', ' ','#',' ','#','#',' ','#','#',' ','#'},
					{'#',' ',' ',' ','#',' ','#',' ','#','#', ' ','#',' ',' ',' ',' ','#','#',' ','#'},
					{'#','#','#','#','#',' ','#',' ','#','#', ' ','#',' ','#',' ',' ',' ','#',' ','#'},
					{'#','#','#','#','#',' ','#',' ','#','#', ' ','#',' ','#',' ','#',' ','#',' ','#'},
					{'#','#','#','#',' ',' ','#',' ','#','#', ' ','#',' ','#',' ','#',' ','#',' ','#'},
					{'#',' ',' ',' ',' ','#','#',' ','#','#', ' ','#',' ','#',' ','#','#','#',' ','#'},
					{'#',' ','#','#','#','#','#',' ','#','#', ' ',' ',' ','#',' ','#','#','#',' ','#'},
					{'#',' ','#',' ',' ',' ',' ',' ','#','#', '#','#','#','#',' ',' ',' ',' ','#','#'},
					{'#',' ',' ',' ',' ','#','#','#','#','#', '#','#','#','#',' ',' ','#',' ',' ','#'},
					{'#','#','#','#','#','#','#','#','#','#', '#','#','#','#','#','#','#','#','#','#'}
			};
		laberinto[21][18] = 'F';
		dibujarLaberinto(laberinto);
        resolverLaberinto(laberinto,12,2);
        dibujarLaberinto(laberinto);
	}

    public static void resolverLaberinto(char matriz[][],int X,int Y)
    {
        
        boolean resultado = caminarLaberinto(matriz,X,Y);
        System.out.println(resultado);
        if(resultado)
        {
            matriz[X][Y]='I';   
        }
        if(!resultado)
        {
            matriz[X][Y]='E';
        }
    }

	public static void dibujarLaberinto(char matriz[][]) 
    {
		int lenX = matriz.length;
		int lenY = matriz[0].length;

		for (int i = 0; i < lenX; i++) {
			for (int j = 0; j < lenY; j++) {
				System.out.print(matriz[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

    public static boolean caminarLaberinto(char matriz[][], int cordF, int cordC)
    {
        if (matriz[cordF][cordC] == 'F') 
        {
            System.out.println("ENCONTRE LA F");
            return true;
        } 
        else 
        {
            int lenF = matriz.length;
            int lenC = matriz[0].length;
            matriz[cordF][cordC] = '*';
            if (cordF != 0) {
                if (matriz[cordF - 1][cordC] == ' ' || matriz[cordF - 1][cordC] == 'F' ) 
                {
                    boolean valor = caminarLaberinto(matriz, cordF - 1, cordC);
                    if(valor)
                    {
                        return true;
                    }
                }
            }
            if (cordC != 0) {
                if (matriz[cordF][cordC - 1] == ' ' || matriz[cordF][cordC-1] == 'F') 
                {
                    boolean valor = caminarLaberinto(matriz, cordF, cordC - 1);
                    if(valor)
                    {
                        return true;
                    }
                }
            }
            if (cordF != lenF - 1) {
                if (matriz[cordF + 1][cordC] == ' ' || matriz[cordF + 1][cordC] == 'F')
                {
                    boolean valor = caminarLaberinto(matriz, cordF + 1, cordC);
                    if(valor)
                    {
                        return true;
                    }
                }
            }
            if (cordC != lenC - 1) {
                if (matriz[cordF][cordC + 1] == ' ' || matriz[cordF][cordC + 1] == 'F')
                {
                    boolean valor = caminarLaberinto(matriz, cordF, cordC + 1);
                    if(valor)
                    {
                        return true;
                    }
                }
            }
            matriz[cordF][cordC] = ' ';
            return false;
        }
    }
}
