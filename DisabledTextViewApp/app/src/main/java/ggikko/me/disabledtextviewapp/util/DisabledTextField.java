package ggikko.me.disabledtextviewapp.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import ggikko.me.disabledtextviewapp.R;

/**
 * Created by ggikko on 16. 6. 2..
 */
public class DisabledTextField extends FrameLayout {

    private TextView caption;
    private TextView text;

    public DisabledTextField(final Context context) {
        this(context, null);
    }

    public DisabledTextField(final Context context, final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DisabledTextField(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View.inflate(getContext(), R.layout.disabled_text_field, this);

        caption = (TextView) findViewById(R.id.caption);
        text = (TextView) findViewById(R.id.value);

        final TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DisabledTextField);
        if (null != typedArray) {
            final String captionText = typedArray.getString(R.styleable.DisabledTextField_caption);
            if (TextUtils.isEmpty(captionText)) {
                caption.setVisibility(GONE);
            } else {
                caption.setText(captionText);
                caption.setVisibility(VISIBLE);
            }

            final String text = typedArray.getString(R.styleable.DisabledTextField_disabledText);
            caption.setText(text);

            typedArray.recycle();
        }
    }

    public final void setCaption(final CharSequence caption) {
        this.caption.setText(caption);
        this.caption.setVisibility(VISIBLE);
    }
    public final void setText(final CharSequence value) {
        this.text.setText(value);
    }
}