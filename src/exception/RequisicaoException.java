package exception;

public class RequisicaoException extends RuntimeException {
    public RequisicaoException(Exception error) {
    }

    @Override
    public String toString() {
        return "Erro ao realizar requisição";

    }
}
