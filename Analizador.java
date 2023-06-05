package mx.ipn.escom.compiladores;

import java.util.List;
import java.util.ArrayList;

public class Analizador {

    private final List<Token> tokens;

    private Token preanalisis;
    private Boolean hayerrores = false;
    private int i=0;
    private final Token identificador = new Token(TipoToken.IDENTIFICADOR, "id",null,i);
    private final Token select = new Token(TipoToken.SELECT, "select", null, i);
    private final Token from = new Token(TipoToken.FROM, "from",null, i);
    private final Token distinct = new Token(TipoToken.DISTINCT, "distinct",null, i);
    private final Token coma = new Token(TipoToken.COMA, ",",null, i);
    private final Token punto = new Token(TipoToken.PUNTO, ".",null, i);
    private final Token asterisco = new Token(TipoToken.ASTERISCO, "*",null, i);
    private final Token finCadena = new Token(TipoToken.EOF, "",null, i);

    private final Token igual = new Token(TipoToken.IGUAL, "=",null, i);
    private final Token menor_que = new Token (TipoToken.MENOR_QUE,"<",null, i);
    private final Token mayor_que = new Token(TipoToken.MAYOR_QUE,">",null, i);
    private final Token mayor_o_igual = new Token(TipoToken.MAYOR_O_IGUAL, ">=",null, i);
    private final Token menor_o_igual = new Token(TipoToken.MENOR_O_IGUAL, "<=",null, i);
    private final Token corchete_abre = new Token(TipoToken.CORCHETE_ABRE,"{",null, i);
    private final Token corchete_cierra = new Token(TipoToken.CORCHETE_CIERRA,"}",null, i);
    private final Token parentesis_abre = new Token (TipoToken.PARENTESIS_ABRE,"(",null, i);
    private final Token parentesis_cierra = new Token(TipoToken.PARENTESIS_CIERRA,")",null, i);
    private final Token punto_coma = new Token(TipoToken.PUNTO_COMA,";",null, i);
    private final Token iftoken = new Token(TipoToken.IF, "if",null, i);
    private final Token fortoken = new Token(TipoToken.FOR, "for",null, i);
    private final Token elsetoken = new Token(TipoToken.ELSE, "else",null, i);
    private final Token print = new Token(TipoToken.PRINT, "print",null, i);
    private final Token returntoken = new Token(TipoToken.RETURN,"return",null, i);
    private final Token whiletoken = new Token(TipoToken.WHILE, "while",null, i);
    private final Token and = new Token(TipoToken.AND, "and",null, i);
    private final Token or = new Token(TipoToken.OR, "or",null, i);
    private final Token diferente_de = new Token(TipoToken.DIFERENTE_DE, "!=",null, i);
    private final Token comparacion = new Token(TipoToken.COMPARACION, "==",null, i);
    private final Token resta = new Token(TipoToken.RESTA, "-",null, i);    
    private final Token suma = new Token(TipoToken.SUMA, "+",null, i);
    private final Token admiracion_cierra = new Token(TipoToken.ADMIRACION_CIERRA,"!",null, i);
    private final Token guion = new Token(TipoToken.GUION, "/",null, i);
    private final Token classtoken = new Token(TipoToken.CLASS, "class",null, i);
    private final Token funtoken = new Token(TipoToken.FUN, "fun",null, i);
    private final Token vartoken = new Token(TipoToken.VAR, "var",null, i);
    //private final Token statement = new Token(TipoToken.STATEMENT, "statement");
    private final Token supertoken = new Token(TipoToken.SUPER, "super",null, i);
    private final Token truetoken = new Token(TipoToken.TRUE, "true",null, i);
    private final Token falsetoken = new Token(TipoToken.FALSE, "false",null, i);
    private final Token nulltoken = new Token(TipoToken.NULL, "null",null, i);
    private final Token thisttoken = new Token(TipoToken.THIS, "this",null, i);
    private final Token number = new Token(TipoToken.NUMBER, "number",null, i);
    private final Token stringtoken = new Token(TipoToken.STRING, "string",null, i);

    private final Token declaration = new Token(TipoToken.DECLARATION, "DECLARATION",null, i);
    private final Token class_decl = new Token(TipoToken.CLASS_DECL, "CLASS_DECL",null, i);
    private final Token fun_decl = new Token(TipoToken.FUN_DECL, "FUN_DECL",null, i);
    private final Token var_decl = new Token(TipoToken.VAR_DECL, "VAR_DECL",null, i);
    private final Token statement = new Token(TipoToken.STATEMENT, "STATEMENT",null, i);
    private final Token class_inher = new Token(TipoToken.CLASS_INHER, "CLASS_INHER",null, i);
    private final Token var_init = new Token(TipoToken.VAR_INIT, "VAR_INIT",null, i);
    private final Token functions = new Token(TipoToken.FUNCTIONS, "FUNCTIONS",null, i);
    private final Token function = new Token(TipoToken.FUNCTION, "FUNCTION",null, i);
    private final Token expr_stmt = new Token(TipoToken.EXPR_STMT, "EXPR_STMT",null, i);
    private final Token for_stmt = new Token(TipoToken.FOR_STMT, "FOR_STMT",null, i);
    private final Token if_stmt = new Token(TipoToken.IF_STMT, "IF_STMT",null, i);
    private final Token print_stmt = new Token(TipoToken.PRINT_STMT, "PRINT_STMT",null, i);
    private final Token return_stmt = new Token(TipoToken.RETURN_STMT, "RETURN_STMT",null, i);
    private final Token while_stmt = new Token(TipoToken.WHILE_STMT, "WHILE_STMT",null, i);
    private final Token block = new Token(TipoToken.BLOCK, "BLOCK",null, i);
    private final Token expression = new Token(TipoToken.EXPRESSION, "EXPRESSION",null, i);
    private final Token for_stmt1 = new Token(TipoToken.FOR_STMT1, "FOR_STMT1",null, i);
    private final Token for_stmt2 = new Token(TipoToken.FOR_STMT2, "FOR_STMT2",null, i);
    private final Token for_stmt3 = new Token(TipoToken.FOR_STMT3, "FOR_STMT3",null, i);
    private final Token else_statement = new Token(TipoToken.ELSE_STATEMENT, "ELSE_STATEMENT",null, i);
    private final Token return_exp_opc = new Token(TipoToken.RETURN_EXP_OPC, "RETURN_EXP_OPC",null, i);
    private final Token block_decl = new Token(TipoToken.BLOCK_DECL, "BLOCK_DECL",null, i);
    private final Token assignment = new Token(TipoToken.ASSIGNMENT, "ASSIGNMENT",null, i);
    private final Token logic_or = new Token(TipoToken.LOGIC_OR, "LOGIC_OR",null, i);
    private final Token assignment_opc = new Token(TipoToken.ASSIGNMENT_OPC, "ASSIGNMENT_OPC",null, i);
    private final Token logic_and = new Token(TipoToken.LOGIC_AND, "LOGIC_AND",null, i);
    private final Token logic_or_2 = new Token(TipoToken.LOGIC_OR_2, "LOGIC_OR_2",null, i);
    private final Token equality = new Token(TipoToken.EQUALITY, "EQUALITY",null, i);
    private final Token logic_and_2 = new Token(TipoToken.LOGIC_AND_2, "LOGIC_AND_2",null, i);
    private final Token comparison = new Token(TipoToken.COMPARISON, "COMPARISON",null, i);
    private final Token equality_2 = new Token(TipoToken.EQUALITY_2, "EQUALITY_2",null, i);
    private final Token term = new Token(TipoToken.TERM, "TERM",null, i);
    private final Token comparison_2 = new Token(TipoToken.COMPARISON_2, "COMPARISON_2",null, i);
    private final Token factor = new Token(TipoToken.FACTOR, "FACTOR",null, i);
    private final Token term_2 = new Token(TipoToken.TERM_2, "TERM_2",null, i);
    private final Token unary = new Token(TipoToken.UNARY, "UNARY",null, i);
    private final Token call = new Token(TipoToken.CALL, "CALL",null, i);
    private final Token primary = new Token(TipoToken.PRIMARY, "PRIMARY",null, i);
    private final Token call_2 = new Token(TipoToken.CALL_2, "CALL_2",null, i);
    private final Token arguments_opc = new Token(TipoToken.ARGUMENTS_OPC, "ARGUMENTS_OPC",null, i);
    private final Token call_opc = new Token(TipoToken.CALL_OPC, "CALL_OPC",null, i);
    private final Token parameters_opc = new Token(TipoToken.PARAMETERS_OPC, "PARAMETERS_OPC",null, i);
    private final Token parameters = new Token(TipoToken.PARAMETERS, "PARAMETERS",null, i);
    private final Token parameters_2 = new Token(TipoToken.PARAMETERS_2, "PARAMETERS_2",null, i);
    private final Token arguments = new Token(TipoToken.ARGUMENTS , "ARGUMENTS",null, i);
    private final Token arguments_2 = new Token(TipoToken.ARGUMENTS_2 , "ARGUMENTS_2",null, i);





    


    
    public Analizador(List<Token> tokens){
        this.tokens = tokens;
        preanalisis = tokens.get(i);
    }

    void parse(){


        PROGRAM();
        if(!hayerrores && !preanalisis.equals(finCadena)){
            System.out.println("Error, no se esperaba el Token " +  preanalisis.tipo);
        }
        else if(hayerrores && !preanalisis.equals(finCadena)){
            System.out.println("Consulta válida");
        }
    }
    
    void PROGRAM(){
        if(hayerrores) return;
        DECLARATION();
    }


    // como se sabe en que funcion se usa switch
    void DECLARATION () {
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.classtoken:
                CLASS_DECL();
                DECLARATION();
                break;
            
            case TipoToken.funtoken:
                FUN_DECL();
                DECLARATION();
                break;
            
            case TipoToken.vartoken:
                VAR_DECL();
                DECLARATION();
                break;
            
            case TipoToken.statement:
                STATEMENT();
                DECLARATION();
                break;

            default:
        }
        //Agregar vacio
    }

    void CLASS_DECL(){ //no lleva switch
        if(hayerrores) return; 
        else if(TipoToken.classtoken == "class")
        {
            coincidir(TipoToken.classtoken);
            coincidir(TipoToken.identificador);
            CLASS_INHER();
            coindicir(TipoToken.corchete_abre);
            FUNCTIONS();
            coincidir(TipoToken.corchete_cierra);    
        }
        else{
            hayerrores = true;
            System.out.println("Consulta no valida");
        }
        
    }

    void CLASS_INHER(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.menor_que:
                coincidir(TipoToken.menor_que);
                coincidir(TipoToken.identificador);
                break;
        default: 
        }
    }
    void FUN_DECL (){ //no lleva switch
        if(hayerrores) return;
        else if(TipoToken.funtoken == "fun")
        {
            coincidir(TipoToken.funtoken);
            FUNCTION();
        }
        else{
            hayerrores = true;
            System.out.println("Consulta no valida");
        }
        

    }
    void VAR_DECL(){ // no lleva switch
        if(hayerrores) return;
        coincidir(TipoToken.vartoken);
        coincidir(TipoToken.identificador);
        VAR_INIT();
    }

    void VAR_INIT() {
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.igual:
                EXPRESSION();
                break;
        default:
        }
    }

    void STATEMENT(){
        if(hayerrores) return;
        switch(preanalisis.tipo){

            case TipoToken.expr_stmt:
                EXPR_STMT();
                break;

            case TipoToken.for_stmt:
                FOR_STMT();
                break;

            case TipoToken.if_stmt:
                IF_STMT();
                break;

            case TipoToken.print_stmt:
                PRINT_STMT();
                break;

            case TipoToken.return_stmt:
                RETURN_STMT();
                break;

            case TipoToken.while_stmt:
                WHILE_STMT();
                break;

            case TipoToken.block:
                BLOCK();
                break;
            default: 
                hayerrores = true;
                System.out.println("Consulta no valida");
        }
    }

    void EXPR_STMT(){ //no lleva switch
        if(hayerrores) return;
        else if (TipoToken.expression == "EXPRESSION")
        {
            EXPRESSION();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
    }

    void FOR_STMT(){ //no lleva switch
        if(hayerrores) return;
        else if (TipoToken.fortoken == "for")
        {
            coincidir(TipoToken.fortoken);
            coincidir(TipoToken.parentesis_abre);
            FOR_STMT1();
            FOR_STMT2();
            FOR_STMT3();
            coincidir(TipoToken.parentesis_cierra);
            STATEMENT();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }

    void FOR_STMT1(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.var_decl:
                VAR_DECL();
                break;
            case TipoToken.expr_stmt:
                EXPR_STMT();
                coincidir(TipoToken.punto_coma);
                break;
            default:
                hayerrores=true;
                System.out.println("Consulta no valida");
        }
    }
    void FOR_STMT2(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.expression:
                EXPRESSION();
                break;
            case TipoToken.punto_coma:    
                coincidir(TipoToken.punto_coma);
                break;
            default: 
                hayerrores=true;
                System.out.println("Consulta no valida");
        }
    }
    void FOR_STMT3(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.expression:
                EXPRESSION();
                break;
        default:
        }
    }
    void IF_STMT(){ //no lleva switch
        if(hayerrores) return;
        else if(TipoToken.iftoken == "if")
        {
            coincidir(TipoToken.iftoken);
            coincidir(TipoToken.parentesis_abre);
            EXPRESSION();
            coincidir(TipoToken.parentesis_cierra);
            STATEMENT();
            ELSE_STATEMENT();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
    }
    void ELSE_STATEMENT (){ //-------------- como se declara else en switch()
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.elsetoken:
                coincidir(TipoToken.elsetoken);
                STATEMENT();
                break;
        default:
        }
    }
    void PRINT_STMT (){//no lleva switch
        if(hayerrores) return;
        else if(TipoToken.print == "print")
        {
            coincidir(TipoToken.print);
            EXPRESSION();        
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida"); 
        }
    }
    void RETURN_STMT (){//no lleva switch
        if(hayerrores) return;
        else if(TipoToken.returntoken == "return")
        {
            coincidir(TipoToken.returntoken);
            RETURN_EXP_OPC();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida"); 
        }

    }
    void RETURN_EXP_OPC(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.expression:
                EXPRESSION();
                break;
        default:
        }
    }
    void WHILE_STMT(){ //no lleva switch
        if(hayerrores) return;
        else if(TipoToken.whiletoken == "while")
        {
            coincidir(TipoToken.whiletoken);
            coincidir (TipoToken.parentesis_abre);
            EXPRESSION ();
            coincidir(TipoToken.parentesis_cierra);
            STATEMENT();            
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }


    }
    void BLOCK(){//no llleva switch
        if(hayerrores) return;
        else if(TipoToken.corchete_abre == "(")
        {
            coincidir(TipoToken.corchete_abre);
            BLOCK_DECL();
            coincidir(TipoToken.corchete_cierra);            
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }


    }
    void BLOCK_DECL (){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.declaration:
                DECLARATION();
                BLOCK_DECL();
                break;
        default:
        }
    }
    void EXPRESSION() {//no lleva switch
        if(hayerrores) return;
        else if(TipoToken.assignment == "ASSIGNMENT")
        {
            ASSIGNMENT();            
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }

    }
    void ASSIGNMENT(){//no lleva switch
        if(hayerrores) return;
        
        else if(TipoToken.logic_or == "LOGIC_OR")
        {
            LOGIC_OR();
            ASSIGNMENT_OPC();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
    }
    void ASSIGNMENT_OPC(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.igual:
                coincidir(TipoToken.igual);
                EXPRESSION();
                break;
        default:
        }
    }
    void LOGIC_OR(){//no lleva switch
        if(hayerrores) return;
        else if(TipoToken.logic_and = "LOGIC_AND")
        {
            LOGIC_AND();
            LOGIC_OR_2();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }
    void LOGIC_OR_2(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.or:
                coincidir(TipoToken.or);
                LOGIC_AND();
                LOGIC_OR_2();
                break;
        default:
        }
    }
    void LOGIC_AND(){//no lleva switch
        if(hayerrores) return;
        else if(TipoToken.equality == "EQUALITY")
        {
            EQUALITY();
            LOGIC_AND_2();
        }
        else
        {
            hayerrores=true;
            System.out.println("Consulta no valida");
        }

    }
    void LOGIC_AND_2(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.and:
                coincidir(TipoToken.and);
                EQUALITY();
                LOGIC_AND_2();
                break;
        default:
        }
    }
    void EQUALITY(){//no lleva switch
        if(hayerrores) return;
        else if(TipoToken.comparison == "COMPARISON")
        {
            COMPARISON();
            EQUALITY_2();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }
    void EQUALITY_2(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.diferente_de:
                coincidir(TipoToken.diferente_de);
                COMPARISON();
                EQUALITY_2();
                break;
            case TipoToken.comparacion:
                coincidir(TipoToken.comparacion);
                COMPARISON();
                EQUALITY_2();
                break;
        default:
        }
    }

    void COMPARISON(){//no lleva switch
        if(hayerrores) return;
        TERM();
        COMPARISON_2();
    }

    void COMPARISON_2(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.mayor_que:
                coincidir(TipoToken.mayor_que);
                TERM();
                COMPARISON_2();
                break;
            case TipoToken.mayor_o_igual:
                coincidir(TipoToken.mayor_o_igual);
                TERM();
                COMPARISON_2();
                break;
            case TipoToken.menor_que:
                coincidir(TipoToken.menor_que);
                TERM();
                COMPARISON_2();
                break;
            case TipoToken.menor_o_igual:
                coincidir(TipoToken.menor_o_igual);
                TERM();
                COMPARISON_2();
                break;
        default:
        }
    }
    
    void TERM() { //no lleva switch
        if(hayerrores) return;
        else if(TipoToken.factor == "FACTOR")
        {
            FACTOR();
            TERM_2();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }

    void TERM_2 ()
    {
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.resta:
                coincidir(TipoToken.resta);
                FACTOR();
                TERM_2();
                break;
            case TipoToken.suma:
                coincidir(TipoToken.suma);
                FACTOR();
                TERM_2();
                break;
        default:
        }
    }

    void FACTOR() { //no lleva switch
        if(hayerrores) return;
        else if(TipoToken.unary == "UNARY")
        {
            UNARY();
            FACTOR_2();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }

    void FACTOR_2(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.guion:
                coincidir(TipoToken.guion);
                UNARY();
                FACTOR_2();
                break;
            case TipoToken.asterisco:
                coincidir(TipoToken.asterisco);
                UNARY();
                FACTOR_2();
                break;
        default:
        }
    }

    void UNARY(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.admiracion_cierra:
                coincidir(TipoToken.admiracion_cierra);
                UNARY();
                break;
            case TipoToken.resta:
                coincdir(TipoToken.resta);
                UNARY();
                break;
            case TipoToken.call:
                CALL();
                break;
            default:
                hayerrores=true;
                System.out.println("Consulta no valida");
        }
    }

    void CALL() {//no lleva switch
        if(hayerrores) return;
        else if (TipoToken.primary == "PRIMARY")
        {
            PRIMARY ();
            CALL_2();
        }
        else {
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }

    void CALL_2() {
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.parentesis_abre:
                coincidir(TipoToken.parentesis_abre);
                ARGUMENTS_OPC();
                coincidir(TipoToken.parentesis_cierra);
                CALL_2();
                break;
            case TipoToken.punto:
                coincidir(TipoToken.punto);
                coincidir(TipoToken.identificador);
                CALL_2();
                break;
        default:
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
    }

    void CALL_OPC(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.call: 
                CALL();
                coincidir(TipoToken.punto);
                break;
        default:
        }
    }

    void PRIMARY (){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.truetoken:
                coincidir(TipoToken.truetoken);
                break;
            case TipoToken.falsetoken:
                coincidir(TipoToken.falsetoken);
                break;
            case TipoToken.nulltoken:
                coincidir(TipoToken.nulltoken);
                break;
            case TipoToken.thistoken:
                coincidir(TipoToken.thistoken);
                break;
            case TipoToken.number:
                coincidir(TipoToken.number);
                break;
            case TipoToken.stringtoken:
                coincidir(TipoToken.stringtoken);
                break;
            case TipoToken.identificador:
                coincidir(TipoToken.identificador);
                break;
            case TipoToken.parentesis_abre:
                coincidir(TipoToken.parentesis_abre);
                EXPRESSION();
                coincidir(TipoToken.parentesis_cierra);
                break;
            case TipoToken.supertoken:
                coincidir(TipoToken.supertoken);
                coincidir(TipoToken.punto);
                coincidir(TipoToken.identificador);
                break;
            default:
                hayerrores=true;
                System.out.println("Consulta no valida");
            }
    }

    void FUNCTION (){ //no lleva switch 
        if(hayerrores) return;
        else if(TipoToken.identificador == "id")
        {
            coincidir(TipoToken.identificador);
            coincidir(TipoToken.parentesis_abre);
            PARAMETERS_OPC();
            coincidir(TipoToken.parentesis_cierra);
            BLOCK();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }

    void FUNCTIONS (){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.function:
                FUNCTION();
                FUNCTIONS();
                break;
        default:
        }
    }

    void PARAMETERS_OPC(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.parameters:
                PARAMETERS();
                break;
        default:
        }
    }

    void PARAMETERS() { //no lleva switch
        if(hayerrores) return;
        else if(TipoToken.identificador == "id")
        {
            coincidir(TipoToken.identificador);
            PARAMETERS_2();            
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }

        
    }

    void PARAMETERS_2 (){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.coma:
                coincidir(TipoToken.coma);
                coincidir(TipoToken.identificador);
                PARAMETERS_2();
                break;
        default:
        }
    }

    void ARGUMENTS_OPC() {
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.arguments:
                ARGUMENTS();
                break;
        default:
        }
    }

    void ARGUMENTS(){//no lleva swtich
        if(hayerrores) return;
        else if(TipoToken.expression == "EXPRESSION")
        {
            EXPRESSION();
            ARGUMENTS_2();
        }
        else{
            hayerrores=true;
            System.out.println("Consulta no valida");
        }
        
    }

    void ARGUMENTS_2(){
        if(hayerrores) return;
        switch(preanalisis.tipo){
            case TipoToken.coma:
                coincidir(TipoToken.coma);
                EXPRESSION();
                ARGUMENTS_2();
                break;
        default:
        }
    }


    void coincidir(TipoToken t){ // Que se le manda como parámetro a coincidir?
        if(hayerrores) return;

        if (preanalisis.tipo == t){
            // preanalisis es igual al siguiente token de entrada
            i++;
            preanalisis = tokens.get(i);
        }
        else{
            // Lanzas un error
            hayerrores = true;
            System.out.println("Error se esperaba un  " + t.tipo);
        }
    }
    
}