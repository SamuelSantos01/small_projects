#include <ctype.h>
#include <locale.h>
#include <stdio.h>
#define tam 3

void exibir(float mat[][2]);
int main(){
    setlocale(LC_ALL, "portuguese");
    float matriz[tam][2];
    char conf;

    for (int i = 0; i < tam; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            if (j == 0)
            {
                printf("\nDigite a latitude atual:");
                scanf("%f", &matriz[i][j]);
            }
            if (j == 1)
            {
                printf("\nExiste temperatura?:");
                scanf("%*c%c", &conf);
                if (toupper(conf) == 'S')
                {
                    printf("\nDigite a temperatura da latitude %.2f:", matriz[i][0]);
                    scanf("%f", &matriz[i][j]);
                }
                else
                {
                    matriz[i][j] = 0;
                }
            }
        }
    }
    exibir(matriz);
    return 0;
}

void exibir(float mat[][2])
{
    printf("\033[H\033[J");
    printf("LATITUDE    TEMPERATURA");
    for (int i = 0; i < tam; i++){
        printf("\n\n");
        for (int j = 0; j < 2; j++){
            if (j == 0){
                printf("%.1f          ", mat[i][j]);
            }
            if (j == 1){
                printf("%.1fº", mat[i][j]);
            }
        }
    }
}