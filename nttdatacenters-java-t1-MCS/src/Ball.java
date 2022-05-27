public class Ball {

    private Integer puntuacion;
    private Integer bounce;

    public Ball() {
       this.puntuacion = 0;
       this.bounce = 0;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getBounce() {
        return bounce;
    }

    public void setBounce(Integer bounce) {
        this.bounce = bounce;
    }
}
