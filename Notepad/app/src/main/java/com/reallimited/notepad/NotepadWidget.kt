package com.reallimited.notepad

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews

class NotepadWidget : AppWidgetProvider() {

    override fun onUpdate
    (
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    )

    {
        val prefs = context.getSharedPreferences("notepad_prefs", Context.MODE_PRIVATE)
        val savedText = prefs.getString("saved_text", "Your note here")

        for (appWidgetId in appWidgetIds)
        {
            val views = RemoteViews(context.packageName, R.layout.widget_notepad)
            views.setTextViewText(R.id.widgetText, savedText)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}