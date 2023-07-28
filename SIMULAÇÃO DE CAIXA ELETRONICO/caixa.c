#include <stdio.h>
#include <locale.h>
#include <stdlib.h>


int main(void){
    setlocale(LC_ALL, "Portuguese");
    int op, mk;
    float conta1 = 1000, aux;

    do{
    system("cls");
    printf("\033[1;36m====CAIXA ELETRONICO====\033[0m\n");
    puts("1 - SALDO\n2 - SACAR\n3 - DEPOSITAR\n4 - FINALIZAR");

    do{
    puts("\nO que deseja?");
    scanf("%d", &op);
    }while(op > 4 || op < 1);

    switch(op){
        case 1:{
            system("cls");
            printf("SALDO: %.2f", conta1);
            puts("\n\npressione 1 para voltar ao menu ou 4 para encerrar finalizar");
            do{
                scanf("%d", &mk);
                if(mk == 1){
                    break;
                }
                else if(mk == 4){
                    op = 4;
                    break;
                }
            }while(mk == 1 || mk == 4);
            break;
        }
        case 2:{
            system("cls");
            printf("Digite o valor de saque: ");
            scanf("%f", &aux);
            conta1 -= aux;
            puts("Saque realizado com sucesso\n");
           puts("\n\npressione 1 para voltar ao menu ou 4 para encerrar finalizar");
            do{
                scanf("%d", &mk);
                if(mk == 1){
                    break;
                }
                else if(mk == 4){
                    op = 4;
                    break;
                }
            }while(mk == 1 || mk == 4);
            break;
        }
        case 3:{
            system("cls");
            printf("Digite o valor para deposito: ");
            scanf("%f", &aux);
            conta1 += aux;
            puts("Deposito realizado com sucesso");
            puts("\n\npressione 1 para voltar ao menu ou 4 para encerrar finalizar");
            do{
                scanf("%d", &mk);
                if(mk == 1){
                    break;
                }
                else if(mk == 4){
                    op = 4;
                    break;
                }
            }while(mk == 1 || mk == 4);
            break;
        }
    }
    }while(op != 4);
    system("cls");
    printf("\033[1;31mObrigado por usar os serviços caixa\n\033[0m\n");
}