package interprete;
import java.util.List;

import javax.print.DocFlavor.STRING;


public class Analizador {

    private final List<Token> tokens;
    
    private int i=0;
    
    private final Token identificador = new Token(TipoToken.IDENTIFICADOR, "", null, i);
    private final Token select = new Token(TipoToken.SELECT, "select", null, i);
    private final Token from = new Token(TipoToken.FROM, "from", null, i);
    private final Token distinct = new Token(TipoToken.DISTINCT, "distinct", null, i);
    private final Token coma = new Token(TipoToken.COMA, ",", null, i);
    private final Token punto = new Token(TipoToken.PUNTO, ".", null, i);
    private final Token asterisco = new Token(TipoToken.ASTERISCO, "*", null, i);
    private final Token finCadena = new Token(TipoToken.EOF, "", null, i);

    private final Token igual = new Token(TipoToken.IGUAL, "=", null, i);
    private final Token menor_que = new Token (TipoToken.MENOR_QUE,"<", null, i);
    private final Token mayor_que = new Token(TipoToken.MAYOR_QUE,">", null, i);
    private final Token mayor_o_igual = new Token(TipoToken.MAYOR_O_IGUAL, ">=", null, i);
    private final Token menor_o_igual = new Token(TipoToken.MENOR_O_IGUAL, "<=", null, i);
    private final Token corchete_abre = new Token(TipoToken.CORCHETE_ABRE,"{", null, i);
    private final Token corchete_cierra = new Token(TipoToken.CORCHETE_CIERRA,"}", null, i);
    private final Token parentesis_abre = new Token (TipoToken.PARENTESIS_ABRE,"(", null, i);
    private final Token parentesis_cierra = new Token(TipoToken.PARENTESIS_CIERRA,")", null, i);
    private final Token punto_coma = new Token(TipoToken.PUNTO_COMA,";", null, i);
    private final Token iftoken = new Token(TipoToken.IF, "if", null, i);
    private final Token fortoken = new Token(TipoToken.FOR, "for", null, i);
    private final Token elsetoken = new Token(TipoToken.ELSE, "else", null, i);
    private final Token print = new Token(TipoToken.PRINT, "print", null, i);
    private final Token returntoken = new Token(TipoToken.RETURN,"return", null, i);
    private final Token whiletoken = new Token(TipoToken.WHILE, "while", null, i);
    private final Token and = new Token(TipoToken.AND, "and", null, i);
    private final Token or = new Token(TipoToken.OR, "or", null, i);
    private final Token diferente_de = new Token(TipoToken.DIFERENTE_DE, "!=", null, i);
    private final Token comparacion = new Token(TipoToken.COMPARACION, "==", null, i);
    private final Token resta = new Token(TipoToken.RESTA, "-", null, i);    
    private final Token suma = new Token(TipoToken.SUMA, "+", null, i);
    private final Token admiracion_cierra = new Token(TipoToken.ADMIRACION_CIERRA,"!", null, i);
    private final Token guion = new Token(TipoToken.GUION, "/", null, i);
    private final Token classtoken = new Token(TipoToken.CLASS, "class", null, i);
    private final Token funtoken = new Token(TipoToken.FUN, "fun", null, i);
    private final Token vartoken = new Token(TipoToken.VAR, "var", null, i);
    //private final Token statement = new Token(TipoToken.STATEMENT, "statement");
    private final Token supertoken = new Token(TipoToken.SUPER, "super", null, i);
    private final Token truetoken = new Token(TipoToken.TRUE, "true", null, i);
    private final Token falsetoken = new Token(TipoToken.FALSE, "false", null, i);
    private final Token nulltoken = new Token(TipoToken.NULL, "null", null, i);
    private final Token thisttoken = new Token(TipoToken.THIS, "this", null, i);
    private final Token number = new Token(TipoToken.NUMBER, "number", null, i);
    private final Token stringtoken = new Token(TipoToken.STRING, "string", null, i);

    private final Token declaration = new Token(TipoToken.DECLARATION, "DECLARATION", null, i);
    private final Token class_decl = new Token(TipoToken.CLASS_DECL, "CLASS_DECL", null, i);
    private final Token fun_decl = new Token(TipoToken.FUN_DECL, "FUN_DECL", null, i);
    private final Token var_decl = new Token(TipoToken.VAR_DECL, "VAR_DECL", null, i);
    private final Token statement = new Token(TipoToken.STATEMENT, "STATEMENT", null, i);
    private final Token class_inher = new Token(TipoToken.CLASS_INHER, "CLASS_INHER", null, i);
    private final Token var_init = new Token(TipoToken.VAR_INIT, "VAR_INIT", null, i);
    private final Token functions = new Token(TipoToken.FUNCTIONS, "FUNCTIONS", null, i);
    private final Token function = new Token(TipoToken.FUNCTION, "FUNCTION", null, i);
    private final Token expr_stmt = new Token(TipoToken.EXPR_STMT, "EXPR_STMT", null, i);
    private final Token for_stmt = new Token(TipoToken.FOR_STMT, "FOR_STMT", null, i);
    private final Token if_stmt = new Token(TipoToken.IF_STMT, "IF_STMT", null, i);
    private final Token print_stmt = new Token(TipoToken.PRINT_STMT, "PRINT_STMT", null, i);
    private final Token return_stmt = new Token(TipoToken.RETURN_STMT, "RETURN_STMT", null, i);
    private final Token while_stmt = new Token(TipoToken.WHILE_STMT, "WHILE_STMT", null, i);
    private final Token block = new Token(TipoToken.BLOCK, "BLOCK", null, i);
    private final Token expression = new Token(TipoToken.EXPRESSION, "EXPRESSION", null, i);
    private final Token for_stmt1 = new Token(TipoToken.FOR_STMT1, "FOR_STMT1", null, i);
    private final Token for_stmt2 = new Token(TipoToken.FOR_STMT2, "FOR_STMT2", null, i);
    private final Token for_stmt3 = new Token(TipoToken.FOR_STMT3, "FOR_STMT3", null, i);
    private final Token else_statement = new Token(TipoToken.ELSE_STATEMENT, "ELSE_STATEMENT", null, i);
    private final Token return_exp_opc = new Token(TipoToken.RETURN_EXP_OPC, "RETURN_EXP_OPC", null, i);
    private final Token block_decl = new Token(TipoToken.BLOCK_DECL, "BLOCK_DECL", null, i);
    private final Token assignment = new Token(TipoToken.ASSIGNMENT, "ASSIGNMENT", null, i);
    private final Token logic_or = new Token(TipoToken.LOGIC_OR, "LOGIC_OR", null, i);
    private final Token assignment_opc = new Token(TipoToken.ASSIGNMENT_OPC, "ASSIGNMENT_OPC", null, i);
    private final Token logic_and = new Token(TipoToken.LOGIC_AND, "LOGIC_AND", null, i);
    private final Token logic_or_2 = new Token(TipoToken.LOGIC_OR_2, "LOGIC_OR_2", null, i);
    private final Token equality = new Token(TipoToken.EQUALITY, "EQUALITY", null, i);
    private final Token logic_and_2 = new Token(TipoToken.LOGIC_AND_2, "LOGIC_AND_2", null, i);
    private final Token comparison = new Token(TipoToken.COMPARISON, "COMPARISON", null, i);
    private final Token equality_2 = new Token(TipoToken.EQUALITY_2, "EQUALITY_2", null, i);
    private final Token term = new Token(TipoToken.TERM, "TERM", null, i);
    private final Token comparison_2 = new Token(TipoToken.COMPARISON_2, "COMPARISON_2", null, i);
    private final Token factor = new Token(TipoToken.FACTOR, "FACTOR", null, i);
    private final Token term_2 = new Token(TipoToken.TERM_2, "TERM_2", null, i);
    private final Token unary = new Token(TipoToken.UNARY, "UNARY", null, i);
    private final Token call = new Token(TipoToken.CALL, "CALL", null, i);
    private final Token primary = new Token(TipoToken.PRIMARY, "PRIMARY", null, i);
    private final Token call_2 = new Token(TipoToken.CALL_2, "CALL_2", null, i);
    private final Token arguments_opc = new Token(TipoToken.ARGUMENTS_OPC, "ARGUMENTS_OPC", null, i);
    private final Token call_opc = new Token(TipoToken.CALL_OPC, "CALL_OPC", null, i);
    private final Token parameters_opc = new Token(TipoToken.PARAMETERS_OPC, "PARAMETERS_OPC", null, i);
    private final Token parameters = new Token(TipoToken.PARAMETERS, "PARAMETERS", null, i);
    private final Token parameters_2 = new Token(TipoToken.PARAMETERS_2, "PARAMETERS_2", null, i);
    private final Token arguments = new Token(TipoToken.ARGUMENTS , "ARGUMENTS", null, i);
    private final Token arguments_2 = new Token(TipoToken.ARGUMENTS_2 , "ARGUMENTS_2", null, i);

    private Boolean hayerrores = false;
    private Token preanalisis;
    



    


    
    public Analizador(List<Token> tokens){
        this.tokens = tokens;
        preanalisis = tokens.get(i);
    }

    void parse(){
        PROGRAM();
        if(!hayerrores && preanalisis.tipo != TipoToken.EOF){
            System.out.println("Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        else if(!hayerrores && preanalisis.tipo == TipoToken.EOF){
            System.out.println("Cadena aceptada");
        }
    }
    
    void PROGRAM(){
        if(hayerrores){
            System.out.print(" 7" + hayerrores);
            return;
        }
        DECLARATION();
    }

    void DECLARATION () {
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.CLASS)
        {
            CLASS_DECL();
            DECLARATION();
        }
        else if(preanalisis.tipo == TipoToken.FUN){
            FUN_DECL();
            DECLARATION();
        }
        else if(preanalisis.tipo == TipoToken.VAR){
            VAR_DECL();
            DECLARATION();
        }
        //Statement
        else if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.FOR || preanalisis.tipo == TipoToken.IF
        || preanalisis.tipo == TipoToken.PRINT || preanalisis.tipo == TipoToken.RETURN
        || preanalisis.tipo == TipoToken.WHILE || preanalisis.tipo == TipoToken.CORCHETE_ABRE
        || preanalisis.tipo == TipoToken.SUMA){
        System.out.println("statement");
            STATEMENT();
            DECLARATION();
        }
        //Agregar vacio
    }

    void CLASS_DECL(){ //no lleva switch
        if(hayerrores) return; 
        if(TipoToken.CLASS == preanalisis.tipo)
        {
            coincidir(TipoToken.CLASS);
            coincidir(TipoToken.IDENTIFICADOR);
            CLASS_INHER();
            coincidir(TipoToken.CORCHETE_ABRE);
            FUNCTIONS();
            coincidir(TipoToken.CORCHETE_CIERRA);    
        }
        else{
            hayerrores = true;
            System.out.println("CLASS_DECL Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        
    }

    void CLASS_INHER(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.MENOR_QUE)
        {
            coincidir(TipoToken.MENOR_QUE);
            coincidir(TipoToken.IDENTIFICADOR);
        }




    }
    void FUN_DECL (){ //no lleva switch
        if(hayerrores) return;
        if(TipoToken.FUN == preanalisis.tipo)
        {
            coincidir(TipoToken.FUN);
            FUNCTION();
        }
        else{
            hayerrores = true;
            System.out.println("FUN_DECL Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        

    }
    void VAR_DECL(){ // no lleva switch
        if(hayerrores) return;
        if(TipoToken.VAR == preanalisis.tipo)
        {
            coincidir(TipoToken.VAR);
            coincidir(TipoToken.IDENTIFICADOR);
            VAR_INIT();    
            coincidir(TipoToken.PUNTO_COMA);        
        }
        else{
            hayerrores = true;
            System.out.println("VAR_DECL Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        
    }

    void VAR_INIT() {
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.IGUAL){
            coincidir(TipoToken.IGUAL);
            EXPRESSION();
        }
    }

    void STATEMENT(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.SUMA){
            EXPR_STMT();
        }
        else if(preanalisis.tipo == TipoToken.FOR){
            FOR_STMT();
        }
        else if(preanalisis.tipo == TipoToken.IF){
            IF_STMT();
        }
        else if(preanalisis.tipo == TipoToken.PRINT){
            PRINT_STMT();
        }
        else if(preanalisis.tipo == TipoToken.RETURN){
            RETURN_STMT();
        }
        else if(preanalisis.tipo == TipoToken.WHILE)
        {
            WHILE_STMT();
        }
        else if(preanalisis.tipo == TipoToken.CORCHETE_ABRE){
            BLOCK();
        }
        else{
            hayerrores = true;
                System.out.println("STATEMENT Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }

    void EXPR_STMT(){ //no lleva switch
        if(hayerrores) return;
        if (preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.SUMA)
        {
            EXPRESSION();
            coincidir(TipoToken.PUNTO_COMA);
        }
        else{
            hayerrores=true;
            System.out.println("EXPR_STMT Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }

    void FOR_STMT(){ //no lleva switch
        if(hayerrores) return;
        if (TipoToken.FOR == preanalisis.tipo)
        {
            coincidir(TipoToken.FOR);
            coincidir(TipoToken.PARENTESIS_ABRE);
            FOR_STMT1();
            FOR_STMT2();
            FOR_STMT3();
            coincidir(TipoToken.PARENTESIS_CIERRA);
            STATEMENT();
        }
        else{
            hayerrores=true;
            System.out.println("FOR_STMT en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        
    }

    void FOR_STMT1(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.VAR)
        {
            VAR_DECL();
        }
        else if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.COMA){
            EXPR_STMT();
        }
        else if(preanalisis.tipo == TipoToken.PUNTO_COMA)
        {
            coincidir(TipoToken.PUNTO_COMA);
        }
        else{
            hayerrores=true;
            System.out.println("FOR_STMT1 Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }
    void FOR_STMT2(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.SUMA) // UNARY, PRIMARY
        {
            EXPRESSION();
            coincidir(TipoToken.PUNTO_COMA);
        }
        else if(preanalisis.tipo == TipoToken.PUNTO_COMA){
            coincidir(TipoToken.PUNTO_COMA);
        }
        else{
            hayerrores=true;
            System.out.println("FOR_STMT2 Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }
    void FOR_STMT3(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.SUMA)
        {
            EXPRESSION();
        }
    }
    void IF_STMT(){ //no lleva switch
        if(hayerrores) return;
        if(TipoToken.IF == preanalisis.tipo)
        {
            coincidir(TipoToken.IF);
            coincidir(TipoToken.PARENTESIS_ABRE);
            EXPRESSION();
            coincidir(TipoToken.PARENTESIS_CIERRA);
            STATEMENT();
            ELSE_STATEMENT();
        }
        else{
            hayerrores=true;
            System.out.println("IF_STMT en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }
    void ELSE_STATEMENT (){ 
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ELSE){
            coincidir(TipoToken.ELSE);
            STATEMENT();
        }
    }
    void PRINT_STMT (){//no lleva switch
        if(hayerrores) return;
        if(TipoToken.PRINT == preanalisis.tipo)
        {
            coincidir(TipoToken.PRINT);
            EXPRESSION();        
            coincidir(TipoToken.PUNTO_COMA);
        }
        else{
            hayerrores=true;
            System.out.println("PRINT_STMT en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo); 
        }
    }
    void RETURN_STMT (){//no lleva switch
        if(hayerrores) return;
        if(TipoToken.RETURN == preanalisis.tipo)
        {
            coincidir(TipoToken.RETURN);
            RETURN_EXP_OPC();
            coincidir(TipoToken.PUNTO_COMA);
        }
        else{
            hayerrores=true;
            System.out.println("RETURN_STMT Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo); 
        }

    }
    void RETURN_EXP_OPC(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.SUMA){
            EXPRESSION();
        }
    }
    void WHILE_STMT(){ //no lleva switch
        if(hayerrores) return;
        if(TipoToken.WHILE == preanalisis.tipo)
        {
            coincidir(TipoToken.WHILE);
            coincidir (TipoToken.PARENTESIS_ABRE);
            EXPRESSION ();
            coincidir(TipoToken.PARENTESIS_CIERRA);
            STATEMENT();            
        }
        else{
            hayerrores=true;
            System.out.println("WHILE_STMT en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }


    }
    void BLOCK(){//no llleva switch
        if(hayerrores) return;
        if(TipoToken.CORCHETE_ABRE == preanalisis.tipo)
        {
            coincidir(TipoToken.CORCHETE_ABRE);
            BLOCK_DECL();
            coincidir(TipoToken.CORCHETE_CIERRA);            
        }
        else{
            hayerrores=true;
            System.out.println("BLOCK Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }


    }
    void BLOCK_DECL (){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.CLASS || preanalisis.tipo == TipoToken.FUN
        || preanalisis.tipo == TipoToken.VAR 
        || preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.FOR || preanalisis.tipo == TipoToken.IF || preanalisis.tipo == TipoToken.PRINT
        || preanalisis.tipo == TipoToken.RETURN || preanalisis.tipo == TipoToken.WHILE
        || preanalisis.tipo == TipoToken.CORCHETE_ABRE
        || preanalisis.tipo == TipoToken.SUMA){
            DECLARATION();
            BLOCK_DECL();
        }
    }
    void EXPRESSION() {//no lleva switch
        if(hayerrores) return;
        ASSIGNMENT();            
        

    }
    void ASSIGNMENT(){//no lleva switch
        if(hayerrores) return;
        LOGIC_OR();
        ASSIGNMENT_OPC();
    }
    void ASSIGNMENT_OPC(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.IGUAL){
            coincidir(TipoToken.IGUAL);
            EXPRESSION();
        }
    }
    void LOGIC_OR(){//no lleva switch
        if(hayerrores) return;
        LOGIC_AND();
        LOGIC_OR_2();        
    }
    void LOGIC_OR_2(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.OR){
            coincidir(TipoToken.OR);
            LOGIC_AND();
            LOGIC_OR_2();
        }
    }
    void LOGIC_AND(){//no lleva switch
        if(hayerrores) return;
        EQUALITY();
        LOGIC_AND_2();
    }
    void LOGIC_AND_2(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.AND){
            coincidir(TipoToken.AND);
            EQUALITY();
            LOGIC_AND_2();
        }
    }
    void EQUALITY(){//no lleva switch
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER){
            COMPARISON();
            EQUALITY_2();
        }
    }
    void EQUALITY_2(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.DIFERENTE_DE)
        {
            coincidir(TipoToken.DIFERENTE_DE);
            COMPARISON();
            EQUALITY_2();
        }
        else if(preanalisis.tipo == TipoToken.COMPARACION)
        {
            coincidir(TipoToken.COMPARACION);
            COMPARISON();
            EQUALITY_2();
        }
    }

    void COMPARISON(){//no lleva switch
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER){
            TERM();
            COMPARISON_2();
        }
    }

    void COMPARISON_2(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.MAYOR_QUE)
        {
            coincidir(TipoToken.MAYOR_QUE);
            TERM();
            COMPARISON_2();
        }
        else if(preanalisis.tipo == TipoToken.MAYOR_O_IGUAL)
        {
            coincidir(TipoToken.MAYOR_O_IGUAL);
            TERM();
            COMPARISON();
        }
        else if(preanalisis.tipo == TipoToken.MENOR_QUE){
            coincidir(TipoToken.MENOR_QUE);
            TERM();
            COMPARISON_2();
        }
        else if(preanalisis.tipo == TipoToken.MENOR_O_IGUAL)
        {
            coincidir(TipoToken.MENOR_O_IGUAL);
            TERM();
            COMPARISON_2();
        }
    }
    
    void TERM() { //no lleva switch
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER){    
            FACTOR();
            TERM_2();
        }
        else{
            hayerrores=true;
            System.out.println("TERM Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        
    }

    void TERM_2 ()
    {
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.RESTA)
        {
            coincidir(TipoToken.RESTA);
            FACTOR();
            TERM_2();
        }
        else if(preanalisis.tipo == TipoToken.SUMA)
        {
            coincidir(TipoToken.SUMA);
            FACTOR();
            TERM_2();
        }
    }

    void FACTOR() { //no lleva switch
        if(hayerrores) return;
        //if(TipoToken.UNARY == preanalisis.tipo)
        //{
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER){
            UNARY();
            FACTOR_2();
        }
        else{
            hayerrores=true;
            System.out.println("FACTOR Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        
    }

    void FACTOR_2(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.GUION)
        {
            coincidir(TipoToken.GUION);
            UNARY();
            FACTOR_2();
        }
        else if(preanalisis.tipo == TipoToken.ASTERISCO)
        {
            coincidir(TipoToken.ASTERISCO);
            UNARY();
            FACTOR_2();
        }
    }

    void UNARY(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA)
        {
            coincidir(TipoToken.ADMIRACION_CIERRA);
            UNARY();
        }
        else if(preanalisis.tipo == TipoToken.RESTA)
        {
            coincidir(TipoToken.RESTA);
            UNARY();
        }
        else if(preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER)
        {
            CALL();
        }
        else {
            hayerrores=true;
            System.out.println("UNARY Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }

    void CALL() {//no lleva switch
        if(hayerrores) return;
        //if (TipoToken.PRIMARY == preanalisis.tipo)
        if(preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER){
            PRIMARY ();
            CALL_2();
        }
        else {
            hayerrores=true;
            System.out.println("CALL Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }

    void CALL_2() {
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.PARENTESIS_ABRE)
        {
            coincidir(TipoToken.PARENTESIS_ABRE);
            ARGUMENTS_OPC();
            coincidir(TipoToken.PARENTESIS_CIERRA);
            CALL_2();
        }
        else if(preanalisis.tipo == TipoToken.PUNTO)
        {
            coincidir(TipoToken.PUNTO);
            coincidir(TipoToken.IDENTIFICADOR);
            CALL_2();
        }
    }

    void CALL_OPC(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER)
        {
            CALL();
            coincidir(TipoToken.PUNTO);
        }
    }

    void PRIMARY (){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.TRUE)
        {
            coincidir(TipoToken.TRUE);
        }
        else if(preanalisis.tipo == TipoToken.FALSE)
        {
            coincidir(TipoToken.FALSE);
        }
        else if(preanalisis.tipo == TipoToken.NULL)
        {
            coincidir(TipoToken.NULL);
        }
        else if(preanalisis.tipo == TipoToken.THIS)
        {
            coincidir(TipoToken.THIS);
        }
        else if(preanalisis.tipo == TipoToken.NUMBER)
        {
            coincidir(TipoToken.NUMBER);
        }
        else if(preanalisis.tipo == TipoToken.STRING)
        {
            coincidir(TipoToken.STRING);
        }
        else if(preanalisis.tipo == TipoToken.IDENTIFICADOR)
        {
            coincidir(TipoToken.IDENTIFICADOR);
        }
        else if(preanalisis.tipo == TipoToken.PARENTESIS_ABRE)
        {
            coincidir(TipoToken.PARENTESIS_ABRE);
            EXPRESSION();
            coincidir(TipoToken.PARENTESIS_CIERRA);
        }
        else if(preanalisis.tipo == TipoToken.SUPER)
        {
            coincidir(TipoToken.SUPER);
            coincidir(TipoToken.PUNTO);
            coincidir(TipoToken.IDENTIFICADOR);   
        }
        else{
            hayerrores=true;
            System.out.println("PRIMARY Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }

    void FUNCTION (){ //no lleva switch 
        if(hayerrores) return;
        if(TipoToken.IDENTIFICADOR == preanalisis.tipo)
        {
            coincidir(TipoToken.IDENTIFICADOR);
            coincidir(TipoToken.PARENTESIS_ABRE);
            PARAMETERS_OPC();
            coincidir(TipoToken.PARENTESIS_CIERRA);
            BLOCK();
        }
        else{
            hayerrores=true;
            System.out.println("FUNCTION Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        
    }

    void FUNCTIONS (){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.IDENTIFICADOR)
        {
            FUNCTION();
            FUNCTIONS();
        }
    }

    void PARAMETERS_OPC(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.IDENTIFICADOR)
        {
            PARAMETERS();
        }
    }

    void PARAMETERS() { //no lleva switch
        if(hayerrores) return;
        if(TipoToken.IDENTIFICADOR == preanalisis.tipo)
        {
            coincidir(TipoToken.IDENTIFICADOR);
            PARAMETERS_2();            
        }
        else{
            hayerrores=true;
            System.out.println("PARAMETERS Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
    }

    void PARAMETERS_2 (){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.COMA)
        {
            coincidir(TipoToken.COMA);
            coincidir(TipoToken.IDENTIFICADOR);
            PARAMETERS_2();
        }
    }

    void ARGUMENTS_OPC() {
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER){
            ARGUMENTS();
        }    
    }

    void ARGUMENTS(){//no lleva swtich
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.ADMIRACION_CIERRA || preanalisis.tipo == TipoToken.RESTA
        || preanalisis.tipo == TipoToken.TRUE || preanalisis.tipo == TipoToken.FALSE
        || preanalisis.tipo == TipoToken.NULL || preanalisis.tipo == TipoToken.THIS
        || preanalisis.tipo == TipoToken.NUMBER || preanalisis.tipo == TipoToken.STRING
        || preanalisis.tipo == TipoToken.IDENTIFICADOR || preanalisis.tipo == TipoToken.PARENTESIS_ABRE
        || preanalisis.tipo == TipoToken.SUPER
        || preanalisis.tipo == TipoToken.SUMA){
            EXPRESSION();
            ARGUMENTS_2();
        }
        else{
            hayerrores=true;
            System.out.println("ARGUMENTS Error en la posición " + preanalisis.linea + ". No se esperaba el token " + preanalisis.tipo);
        }
        
    }

    void ARGUMENTS_2(){
        if(hayerrores) return;
        if(preanalisis.tipo == TipoToken.COMA)
        {
            coincidir(TipoToken.COMA);
            EXPRESSION();
            ARGUMENTS_2();
        }
    }


    void coincidir(TipoToken t){ // Que se le manda como parámetro a coincidir?
        if(hayerrores) return;
        System.out.println("Token es  " + t + " Preanalisis es " + preanalisis);

        if (preanalisis.tipo == t){
            // preanalisis es igual al siguiente token de entrada
            i++;
            preanalisis = tokens.get(i);
        }
        else{
            // Lanzas un error
            hayerrores = true;
            //System.out.println("Error se esperaba un  " + t.tipo);
            System.out.println("Error se esperaba un  " + t);
        }
    }
    
}