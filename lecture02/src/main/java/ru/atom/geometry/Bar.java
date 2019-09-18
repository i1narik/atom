package ru.atom.geometry;

public class Bar implements Collider {
    private int firstCornerX;
    private int firstCornerY;
    private int secondCornerX;
    private int secondCornerY;

    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        if (firstCornerX < secondCornerX) {
            this.firstCornerX = firstCornerX;
            this.secondCornerX = secondCornerX;
        } else {
            this.firstCornerX = secondCornerX;
            this.secondCornerX = firstCornerX;
        }

        if (firstCornerY < secondCornerY) {
            this.firstCornerY = firstCornerY;
            this.secondCornerY = secondCornerY;
        } else {
            this.firstCornerY = secondCornerY;
            this.secondCornerY = firstCornerY;
        }
    }

    @Override
    public boolean isColliding(Collider other) {
        if (this.equals(other))
            return true;

        if (other instanceof Point) {
            Point point = (Point) other;
            if (point.x < this.firstCornerX || point.x > this.secondCornerX)
                return false;
            if (point.y < this.firstCornerY || point.y > this.secondCornerY)
                return false;
            return true;
        } else if (other instanceof Bar) {
            Bar bar = (Bar) other;
            if (this.firstCornerX > bar.secondCornerX || bar.firstCornerX > this.secondCornerX)
                return false;
            if (this.firstCornerY > bar.secondCornerY || bar.firstCornerY > this.secondCornerY)
                return false;
            return true;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        if (this.firstCornerX == bar.firstCornerX
                && this.firstCornerY == bar.firstCornerY
                && this.secondCornerX == bar.secondCornerX
                && this.secondCornerY == bar.secondCornerY)
            return true;

        return false;
    }
}
