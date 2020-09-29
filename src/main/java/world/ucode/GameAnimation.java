package world.ucode;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.geometry.Rectangle2D;
import javafx.util.Duration;

public class GameAnimation extends Transition {
    private final ImageView imageView;
    private final int count;
    private int offsetX;
    private final int width;
    private final int height;

    public GameAnimation(
            ImageView imageView,
            Duration duration,
            int count, int offsetX,
            int offsetY, int width,
            int height
    ) {
        this.imageView = imageView;
        this.count = count;
        this.offsetX = offsetX;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));

    }

    protected void interpolate(double frac) {
        final int index = Math.min((int)Math.floor(count*frac), count - 1);
        final int x = (index % count) * width + offsetX;
        final int y = 1;
        imageView.setViewport(new Rectangle2D(x, y, width, height));
    }
}
