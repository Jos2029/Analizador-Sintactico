package interprete;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner {

    private final String source;

    private final List<Token> tokens = new ArrayList<>();

    private int linea = 1;

    private static final Map<String, TipoToken> palabrasReservadas;
    static {
        palabrasReservadas = new HashMap<>();
        palabrasReservadas.put("y", TipoToken.Y);
        palabrasReservadas.put("clase", TipoToken.CLASE);
        palabrasReservadas.put("print", TipoToken.PRINT);
        /*palabrasReservadas.put("ademas", );
        palabrasReservadas.put("falso", );
        palabrasReservadas.put("para", );
        palabrasReservadas.put("fun", ); //definir funciones
        palabrasReservadas.put("si", );
        palabrasReservadas.put("nulo", );
        palabrasReservadas.put("o", );
        palabrasReservadas.put("imprimir", );
        palabrasReservadas.put("retornar", );
        palabrasReservadas.put("super", );
        palabrasReservadas.put("este", );
        palabrasReservadas.put("verdadero", );
        palabrasReservadas.put("var", ); //definir variables
        palabrasReservadas.put("mientras", );*/
        palabrasReservadas.put("if", TipoToken.IF);
        palabrasReservadas.put("for", TipoToken.FOR);
        palabrasReservadas.put("while", TipoToken.WHILE);
        palabrasReservadas.put("var", TipoToken.VAR);
        palabrasReservadas.put("class", TipoToken.CLASS);
        palabrasReservadas.put("fun",TipoToken.FUN);
        palabrasReservadas.put("return", TipoToken.RETURN);
    }

    Scanner(String source){
        this.source = source + " ";
    }

    List<Token> scanTokens(){
        //Aquí va el corazón del scanner.
        
        int estado = 0, i = 0;
        String lexema = "";

        while (i <source.length())
        {
            char caracter = source.charAt(i);
            switch (estado){
                case 0:
                    if(caracter == '>')
                    {
                        lexema += caracter;
                        estado = 1;
                    }
                    else if (caracter == '<')
                    {
                        lexema += caracter;
                        estado = 2;
                    }
                    else if (caracter == '=')
                    {
                        lexema += caracter;
                        estado = 3;
                    }

                    else if(caracter ==';')
                    {
                        tokens.add(new Token(TipoToken.PUNTO_COMA, ";", null, linea));
                    }

                    else if(caracter ==',')
                    {
                        tokens.add(new Token(TipoToken.COMA, ",", null, linea));
                    }

                    else if(caracter == '\"')
                    {
                        estado = 4;
                    }
                    else if(caracter == '(')
                    {
                        tokens.add(new Token(TipoToken.PARENTESIS_ABRE, "(", null, linea));
                        estado = 0;
                    }

                    else if (caracter == ')')
                    {
                        tokens.add(new Token(TipoToken.PARENTESIS_CIERRA, ")", null, linea));
                    }
                    else if(caracter == '{')
                    {
                        tokens.add(new Token(TipoToken.CORCHETE_ABRE, "{", null, linea));
                    }
                    else if(caracter == '}')
                    {
                        tokens.add(new Token(TipoToken.CORCHETE_CIERRA, "}", null, linea));
                    }
                    if(caracter == '*')
                    {
                       //No requuiere de dos
                       tokens.add(new Token(TipoToken.ASTERISCO, "*", null, linea));
                    }

                    else if(caracter =='+')
                    {
                        //No requiere de dos
                        tokens.add(new Token(TipoToken.SUMA, "+", null, linea));
                        estado = 0;
                    }

                    else if(caracter == '-')
                    {
                        // No requiere de dedos
                        tokens.add(new Token(TipoToken.RESTA, "-", null, linea));
                    }
                    
                    else if(caracter == '.')
                    {
                        
                        tokens.add(new Token(TipoToken.PUNTO, ".", null, linea));
                        
                    }

                    else if(caracter == '/')
                    {
                        // Requiere de dos
                        estado = 100;
                    }
                    
                    else if(Character.isDigit(caracter)){
                        // Cambiar al estado donde se trabajen los números
                        //lexema = String.valueOf(caracter);
                        lexema += caracter;
                        estado = 5;
                    }

                    //Aquí checar que isAlphabetic solo sirva para A-Z, a-z y no para otros caracteres
                    else if (Character.isAlphabetic(caracter)){
                        estado = 6;
                        lexema += caracter;
                    }
                    else if(caracter == '"')
                    {
                        estado = 7;
                        lexema += caracter;
                    }
                    break;
                    
                
                case 1:
                    
                    if(caracter == '=')
                    {
                        lexema+=caracter;
                        tokens.add(new Token(TipoToken.MAYOR_O_IGUAL,lexema, null, linea));
                        
                    }
                    else
                    {
                        tokens.add(new Token(TipoToken.MAYOR_QUE, lexema, null, linea));
                    }
                    lexema = "";
                    estado = 0;
                    
                    break;
                
                case 2:
                    if(caracter == '=')
                    {
                        lexema+=caracter;
                        tokens.add(new Token(TipoToken.MENOR_O_IGUAL, lexema, null, linea));
                        //i--;    
                    }
                    else if(caracter != '=' && caracter != '<')
                    {
                        tokens.add(new Token(TipoToken.MENOR_QUE, "<", null, linea));

                    }
                    estado = 0;
                    lexema = "";
                    
                break;
                case 3:
                    if(caracter == '=')
                    {
                        lexema += caracter;
                        tokens.add(new Token (TipoToken.COMPARACION, lexema, null, linea));
                    }
                    else
                    {
                        tokens.add(new Token(TipoToken.IGUAL, "=", null, linea));
                    }
                    estado = 0;
                    lexema = "";
                break;
                /*case 4:
                    if(caracter != '\"')
                    {
                        lexema += caracter;
                        estado = 4;
                    }
                    else if(caracter == '\"')
                    {
                        tokens.add(new Token(TipoToken.CADENA));
                    }
                break;*/
                case 5: 
                    //aceptar numeros del 0 al 9
                    
                    if(Character.isDigit(caracter)|| caracter == '.')
                    {
                        lexema += caracter;
                        estado = 5;
                    }
                    else{
                        //if()
                        tokens.add(new Token(TipoToken.NUMBER, lexema, null, linea));
                        estado = 0;
                        lexema = "";
                        i--;
                    }
                    //lexema += caracter;
                    
                    //tokens.add(new Token(TipoToken.DIGITO, lexema, null, linea));
                    
                    
                break;

                case 6:
                    if(Character.isDigit(caracter) || Character.isAlphabetic(caracter)){
                        estado = 6;
                        lexema += caracter;
                        //tokens.add(new Token(TipoToken.VARIABLE, lexema, null, linea)); no se ocupa
                    }
                    else{
                        TipoToken tt = palabrasReservadas.get(lexema);
                        if(tt == null){
                            tokens.add(new Token(TipoToken.IDENTIFICADOR, lexema, null, linea));
                        }
                        else{
                            tokens.add(new Token(tt, lexema, null, linea));
                        }
                        estado = 0;
                        lexema = "";
                        i--;
                    }
                break;
               
                case 7:
                    if(caracter != '"')
                    {
                        lexema += caracter;
                    }
                    else{
                        lexema += caracter;
                        tokens.add(new Token(TipoToken.STRING, lexema, null, linea));
                        estado = 0;
                        lexema = "";
                        
                    }
                break;
                //comentarios    
                case 100:
                    if(caracter == '/')
                    {
                        estado = 101;
                    }
                    else if(caracter == '*')
                    {
                        estado = 102;
                    }
                break;
                case 101:
                    if(caracter == '\n')
                        {
                            estado = 0;
                        }
                break;
                case 102:
                    if(caracter != '*')
                    {
                        estado = 102;
                    }
                    if(caracter == '*')
                     {
                       estado = 103; 
                     }
                break;
                case 103:
                     if(caracter == '/');
                     {
                        estado = 0;
                     }
                break;
            }
                i++;























        }
    
    
        
        /*
        Analizar el texto de entrada para extraer todos los tokens
        y al final agregar el token de fin de archivo
         */
        tokens.add(new Token(TipoToken.EOF, "", null, linea));
        return tokens;
    }
}

/*
Signos o símbolos del lenguaje:
(
)
{
}
,
.
;
-
+
*
/
!
!=
=
==
<
<=
>
>=
// -> comentarios (no se genera token)
/* ... * / -> comentarios (no se genera token)
Identificador,
Cadena
Numero
Cada palabra reservada tiene su nombre de token

 */