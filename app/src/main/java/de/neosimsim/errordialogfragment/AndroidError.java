package de.neosimsim.errordialogfragment;

import android.content.Context;

public class AndroidError extends Error {
    private final String mPlaceholder = "%c";

    private int titleResId;
    private int mMessageResId;
    private String[] mReplacements;

    /**
     * Creates a new Error object. Each replacement will replace one placeholder
     * "%c" in the message.
     */
    public AndroidError(Throwable cause, int titleResId, int messageResId, String... replacements) {
        super(null, cause);
        this.titleResId = titleResId;
        this.mMessageResId = messageResId;
        this.mReplacements = replacements;
    }

    public AndroidError(int titleResId, int messageResId, String... replacements) {
        this(null, titleResId, messageResId, replacements);
    }

    public AndroidError(Throwable cause, int titleResId, String message) {
        super(message, cause);
        this.titleResId = titleResId;
    }

    public AndroidError(int titleResId, String message) {
        this(null, titleResId, message);
    }

    @Override
    public String getMessage() {
        throw new RuntimeException("Unsupported method. Use getMessage(Context) instead.");
    }

    @Override
    public String getLocalizedMessage() {
        throw new RuntimeException("Unsupported method. Use getMessage(Context) instead.");
    }

    public String getMessage(Context context) {
        String message = context.getString(mMessageResId);
        for (String replacement : mReplacements) {
            message = message.replace(mPlaceholder, replacement);
        }
        return message;
    }

    public String getTitle(Context context) {
        return context.getString(titleResId);
    }
}
