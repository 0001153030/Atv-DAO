public class ProfessorSession {

    private static boolean loggedIn = false;
    private static int professorId;

    /**
     * Verifica se o professor está logado.
     * @return true se o professor estiver logado, caso contrário, false.
     */
    public static boolean isLoggedIn() {
        return loggedIn;
    }

    /**
     * Define o status de login do professor.
     * @param status true para logado, false para deslogado.
     */
    public static void setLoggedIn(boolean status) {
        loggedIn = status;
    }

    /**
     * Obtém o ID do professor logado.
     * @return ID do professor logado.
     */
    public static int getProfessorId() {
        return professorId;
    }

    /**
     * Define o ID do professor logado.
     * @param id ID do professor.
     */
    public static void setProfessorId(int id) {
        professorId = id;
    }
}
