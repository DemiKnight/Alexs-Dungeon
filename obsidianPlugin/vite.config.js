import {defineConfig} from "vite";
import { resolve } from 'path';
import scalaJSPlugin from "@scala-js/vite-plugin-scalajs";

export default defineConfig({
    plugins: [scalaJSPlugin({
        cwd: '..',
        projectID: 'obsidianPlugin'
    })],
    build: {
        lib: {
            entry: resolve(__dirname, "main.js"),
            name: "main.js"
        }
    }
});