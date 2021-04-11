package com.itijm.jitselogs.Util;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.WebhookClientBuilder;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;

public class DiscordWebhook {

    public static void send(int color, String message, Boolean ping) {
        WebhookClient client = new WebhookClientBuilder("https://discord.com/api/webhooks/830722111944917013/anl9bt5LIhG6g9HfgmajFkcbFJ-x-a3yCzv8iybyvjsr-XtD_AOr3N3k6LC1IRJOzq-M").build();

        WebhookEmbed content = new WebhookEmbedBuilder()
                .setColor(color)
                .setDescription(message)
                .build();

        if (ping) {
            client.send("@everyone").whenComplete((v, e) -> {
                if (e != null && e.getMessage().contains("Request returned failure 404")) {
                    System.out.println("Request failed");
                }
            });
        }

        client.send(content).whenComplete((v, e) -> {
            if (e != null && e.getMessage().contains("Request returned failure 404")) {
                System.out.println("Request failed");
            }
            client.close();
        });
    }
}